/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.learn.dxp.importer;

import com.liferay.headless.delivery.client.dto.v1_0.ContentField;
import com.liferay.headless.delivery.client.dto.v1_0.ContentFieldValue;
import com.liferay.headless.delivery.client.dto.v1_0.StructuredContent;
import com.liferay.headless.delivery.client.resource.v1_0.StructuredContentResource;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.vladsch.flexmark.ext.anchorlink.AnchorLinkExtension;
import com.vladsch.flexmark.ext.aside.AsideExtension;
import com.vladsch.flexmark.ext.attributes.AttributesExtension;
import com.vladsch.flexmark.ext.definition.DefinitionExtension;
import com.vladsch.flexmark.ext.footnotes.FootnoteExtension;
import com.vladsch.flexmark.ext.gfm.strikethrough.StrikethroughExtension;
import com.vladsch.flexmark.ext.media.tags.MediaTagsExtension;
import com.vladsch.flexmark.ext.superscript.SuperscriptExtension;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.ext.toc.TocExtension;
import com.vladsch.flexmark.ext.typographic.TypographicExtension;
import com.vladsch.flexmark.ext.yaml.front.matter.YamlFrontMatterExtension;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.data.MutableDataSet;

import java.io.File;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;

/**
 * @author Brian Wing Shun Chan
 * @author Rich Sezov
 */
public class Main {

	public static void main(String[] arguments) throws Exception {
		Set<String> fileNames = new TreeSet<>();

		_addFileNames("../docs", fileNames);

		for (String fileName : fileNames) {
			if (fileName.contains("/en/") && fileName.endsWith(".md")) {
				System.out.println(fileName);

				_uploadHTML(fileName);
			}
		}
	}

	private static void _addFileNames(String fileName, Set<String> fileNames) {
		File file = new File(fileName);

		if (file.isDirectory()) {
			for (String currentFileName : file.list()) {
				_addFileNames(fileName + "/" + currentFileName, fileNames);
			}
		}

		fileNames.add(fileName);
	}

	private static String _getTitle(String text) {
		int x = text.indexOf("#");

		int y = text.indexOf(StringPool.NEW_LINE, x);

		String title = text.substring(x + 1, y);

		return title.trim();
	}

	private static String _toHTML(String text) {
		MutableDataSet mutableDataSet = new MutableDataSet()
			.set(HtmlRenderer.GENERATE_HEADER_ID, true)
			.set(AsideExtension.EXTEND_TO_BLANK_LINE, false)
			.set(AsideExtension.IGNORE_BLANK_LINE, false)
			.set(AsideExtension.ALLOW_LEADING_SPACE, true)
			.set(AsideExtension.INTERRUPTS_PARAGRAPH, true)
			.set(AsideExtension.INTERRUPTS_ITEM_PARAGRAPH, true)
			.set(AsideExtension.WITH_LEAD_SPACES_INTERRUPTS_ITEM_PARAGRAPH, true);

		mutableDataSet.set(Parser.EXTENSIONS, 
			Arrays.asList(TablesExtension.create(),
			AnchorLinkExtension.create(),
			AsideExtension.create(),
			AttributesExtension.create(),
			DefinitionExtension.create(),
			FootnoteExtension.create(),
			MediaTagsExtension.create(),
			StrikethroughExtension.create(),
			SuperscriptExtension.create(),
			TocExtension.create(),
			TypographicExtension.create(),
			YamlFrontMatterExtension.create()
		));

		HtmlRenderer htmlRenderer = HtmlRenderer.builder(
			mutableDataSet
		).build();

		Parser parser = Parser.builder(
			mutableDataSet
		).build();

		return htmlRenderer.render(parser.parse(text));
	}

	private static StructuredContent _toStructuredContent(String fileName)
		throws Exception {

		StructuredContent structuredContent = new StructuredContent();

		structuredContent.setAvailableLanguages(
			new String[] {"en-US", "ja-JP"});

		String englishText = FileUtils.readFileToString(
			new File(fileName), StandardCharsets.UTF_8);

		ContentFieldValue englishContentFieldValue = new ContentFieldValue() {
			{
				data = _toHTML(englishText);
			}
		};

		String englishTitle = _getTitle(englishText);

		ContentFieldValue japaneseContentFieldValue;

		String japaneseTitle = englishTitle;

		File japaneseFile = new File(fileName.replace("/en/", "/ja/"));

		if (japaneseFile.exists()) {
			String japaneseText = FileUtils.readFileToString(
				japaneseFile, StandardCharsets.UTF_8);

			japaneseContentFieldValue = new ContentFieldValue() {
				{
					data = _toHTML(japaneseText);
				}
			};
			japaneseTitle = _getTitle(japaneseText);
		}
		else {
			japaneseContentFieldValue = englishContentFieldValue;
		}

		structuredContent.setContentFields(
			new ContentField[] {
				new ContentField() {
					{
						contentFieldValue = englishContentFieldValue;
						contentFieldValue_i18n = HashMapBuilder.put(
							"en-US", englishContentFieldValue
						).put(
							"ja-JP", japaneseContentFieldValue
						).build();
						name = "content";
					}
				}
			});
		structuredContent.setContentStructureId(_CONTENT_STRUCTURE_ID);
		structuredContent.setTitle(_getTitle(englishText));
		structuredContent.setTitle_i18n(
			HashMapBuilder.put(
				"en-US", englishTitle
			).put(
				"ja-JP", japaneseTitle
			).build());

		return structuredContent;
	}

	private static void _uploadHTML(String fileName) throws Exception {
		StructuredContentResource.Builder builder =
			StructuredContentResource.builder();

		StructuredContentResource structuredContentResource =
			builder.authentication(
				"test@liferay.com", "test"
			).build();

		structuredContentResource.postSiteStructuredContent(
			_GROUP_ID, _toStructuredContent(fileName));
	}

	private static final long _CONTENT_STRUCTURE_ID = 39756;

	private static final long _GROUP_ID = 20123;

}
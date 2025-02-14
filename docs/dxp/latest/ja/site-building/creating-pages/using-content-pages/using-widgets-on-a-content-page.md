# コンテンツページでのウィジェットの使用
<!--TASK: Reconsider-->
ウィジェットセクションは、ウィジェットページ</a>の
**追加** メニューと同じように機能します。 使用可能なウィジェットの完全なリストが表示され、それらをページに追加できます。 主な違いは、コンテンツページではウィジェットの主な設定オプションしか使用できないことです。</p> 



```{note}
ウィジェットページでは、ウィジェットは [render-weight]（https://learn.liferay.com/reference/latest/en/dxp/definitions/liferay-portlet-app_7_3_0.dtd.html#render-weight） に従ってレンダリングされますが、コンテントページではその限りではありません。 その代わり、ページ上に表示される順番（左から右、上から下）にレンダリングされます。
```




<a name="adding-widgets-on-content-pages" />

## コンテンツページにウィジェットを追加する

次の手順に従って、ウィジェットをコンテンツページに追加します。

1. [コンテントページに要素を追加](./adding-elements-to-content-pages.md)している間に、 [ウィジェットパネル](./content-page-editor-ui-reference.md) を開き、利用できるウィジェットを参照したり名前でウィジェットを探したりすることができます。
1. ウィジェットを配置したいレイアウトの列と行にドラッグします。

ウィジェットは、Wikiディスプレイまたはアセットパブリッシャーのような動的公開ツールです。 ウィジェットで表示するコンテンツは、長文のテキストや画像ギャラリーなど、さまざまなものがあります。



<a name="configuring-widgets-on-content-pages" />

## コンテンツページでのウィジェットの構成

次の手順に従って、コンテンツページでウィジェットを構成します。

1. ウィジェットにカーソルを合わせます。
1. オプションメニュー（![Options Menu](../../../images/icon-app-options.png)）を開き、 ［**Configuration**］ を選択します。 ここからは、ウィジェットに応じていくつかのオプションがあります。
   
   ![コンテンツページのウィジェットは、オプションメニューから設定できます。](./using-widgets-on-a-content-page/images/01.png)

1. ［**保存**］ をクリックして変更を適用します。



```{note}
Liferay Portal 7.3 GA2以降では、ウィジェットのオプションメニューから*権限*を選択して、ウィジェットの権限を設定することも可能です。
```




<a name="configuring-widget-permissions-on-content-pages" />

## コンテンツページでのウィジェット権限の構成

Liferay Portal 7.3 GA2以降、コンテンツページからウィジェットの権限を構成できます。 次の手順に従って、コンテンツページでウィジェットの権限を構成します。

1. ウィジェットにカーソルを合わせます。
1. オプションメニュー（![Options Menu](../../../images/icon-app-options.png)）を開き、 ［**Permissions**］ を選択します。
1. 表示される新しいウィンドウで、ロールの権限をオンまたはオフにします。
1. ［**Save**］ をクリックして変更を適用します。

![コンテンツページのウィジェットの権限は、オプションメニューから設定できます。](./using-widgets-on-a-content-page/images/02.png)



```{note}
 [ページテンプレート] (../adding-pages/creating-a-page-template.md) に基づいてページを作成すると、権限もコピーされます。 マスターページの権限は、ページではなく、[マスターページ](../defining-headers and footers/managing-master-page-templates.md) で設定されます。
```




<a name="content-page-limitations-for-widgets" />

## ウィジェットのコンテンツページの制限

コンテンツページでもウィジェットの基本的な設定オプションや権限にアクセスできますが、ウィジェットページでのみ利用可能なオプションもあります。

****ネストレイアウト** : ウィジェットの中のウィジェットはウィジェットページでのみサポートされています。
****ウィジェットルック & フィール** ：ウィジェットページでは、ウィジェットの設定メニューからルック＆フィールメニューにアクセスでき、CSSをきめ細かくコントロールできます。 コンテンツのルックアンドフィールはテーマまたはフラグメントを使用して定義されているため、コンテンツページのウィジェットでは使用できません。
****設定用テンプレート** ：ウィジェットの構成設定をテンプレートに保存する設定用テンプレートは、ウィジェットページでのみ使用できます。
****エクスポート/インポート** ：ウィジェットページのウィジェットのアプリケーションデータのみをエクスポート/インポートできます。



<a name="additional-information" />

## 追加情報

- [コンテントページの使用](../using-content-pages.md)
- [コンテンツページへの要素の追加](./adding-elements-to-content-pages.md)
- [コンテントページエディタUIリファレンス](./content-page-editor-ui-reference.md)

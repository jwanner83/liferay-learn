# サイト階層

サイトは組織と同じように、子サイトを使って階層的に構成することができます。 サイトを階層的に整理することで、サイト間でのコンテンツの共有が容易になります。 サイトと組織の違いは、サイトがページ、コンテンツ、アプリケーションデータ、およびユーザー（サイトメンバーシップを介して）を整理するのに対し、組織はユーザーのみをグループ化することです。 サイト階層については、以下で詳しく説明します。

* [サイト間のコンテンツ共有](#content-sharing-between-sites)
* [サイト階層のロールとパーミッション](#site-hierarchy-roles-and-permissions)
* [サイト階層アプリケーション](#site-hierarchy-applications)
* [サイトディレクトリアプリケーション](#the-sites-directory-application)
* [サイトマップアプリケーション](#the-site-map-application)

<a name="content-sharing-between-sites" />

## サイト間のコンテンツ共有

コンテンツの共有は、同一階層内のサイトで利用できます。 例えば、親サイトに **Devcon Presentation** というドキュメントタイプがあり、すべての子サイトがそのコピーを持つ必要がある場合、親サイトの管理者はコンテンツ共有を有効にして、ドキュメントタイプを子サイトと自動的に共有することができます。 また、コンテンツ共有権限を設定することで、すべてのサイト管理者が自分の管理するサイトでコンテンツを共有することができます。 これらのコンテンツタイプは、サイト間で共有することができます。

* Web コンテンツストラクチャー
* Webコンテンツテンプレート
* ドキュメントタイプ
* ボキャブラリーとカテゴリー
* ウィジェットテンプレート
* データ定義（動的データリスト）

関連する設定可能なプロパティのリストについては、Liferayの`portal.properties`ファイルの [サイトの管理ポートレット](https://learn.liferay.com/reference/latest/en/dxp/propertiesdoc/portal.properties.html#Sites%20Admin%20Portlet) のセクションを参照してください。 例えば、`Sites.content.sharing.with.children.enabled`プロパティでは、サイトと子サイト間のコンテンツ共有を無効/有効にすることができますが、サイト管理者はサイトごとに設定することができます。

<a name="site-hierarchy-roles-and-permissions" />

## サイト階層のロールと権限設定

これらのルールは、サイトの階層に適用されます。

* 階層内の各子サイトは、それぞれの管理者がいます。
* サイト管理者のロール権限は、階層内の子サイトに伝わりません。
* サイト管理者が子サイトを作成した場合、その子サイトでも同じ権限が与えられます。 これは、サイトを作成すると、そのサイトの所有者になるからです（継承ではありません）。
* サイト管理者は、他のサイト管理者が作成した子サイトのデフォルトのロールを持ちません。

```{note}
サイト/子サイトの階層にあるすべてのサイトへの管理アクセス権をユーザーに持たせたい場合は、サイト管理者ロールをベースにして、*子サイトを管理する*権限を持つロールを作成する必要があります。
```

<a name="navigating-site-hierarchy-with-the-sites-directory-application" />

## サイトディレクトリアプリケーションによるサイト階層のナビゲーション

サイトディレクトリアプリケーションは、サイトと子サイトの階層を表示する設定可能なアプリケーションです。 これにより、ユーザーは表示されたサイトのいずれかにナビゲートすることができます。 このアプリを使ってサイトの階層を表示するには、以下の手順で行います。

1. サイトディレクトリアプリケーションをページに追加します。
1. その **設定** ウィンドウを開きます。
1. ［表示形式］の ［**階層リスト**］ を選択します。

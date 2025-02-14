# ウィジェットページのユーザーパーソナライズの有効化

管理者は、ウィジェットページの一部またはすべてのセクション（ページレイアウトの行と列）を、サイトメンバーがカスタマイズできるものとして指定できます。 ページのカスタマイズは、カスタマイズを行ったユーザーにのみ表示されます。 以下の手順では、これらのトピックについて説明します。

  - [ページセクションをカスタマイズ可能にする](#enabling-page-customizations)
  - [カスタマイズ可能なページセクションの変更](#customizing-pages)
  - [非サイトメンバーにページをカスタマイズする権限を割り当てる](#granting-roles-permission-to-customize-pages)

## ページのカスタマイズを有効にする

ページのカスタマイズを有効にするには、次の手順に従います。

1.  製品メニューを開き、サイトメニューの **サイトビルダー** → **ページ** に移動します。

2.  サイトのメンバーに変更を許可するページの横にある[アクション]メニューを開き、[**構成**]を選択します。

3.  ページ上部の[**Advanced**]タブを選択し、[**Customization Settings**]パネルを展開します。

4. **Customizable** オプションをYesに切り替えます。

    ![ページのカスタマイズを有効にするには、ページの横にある[ページの構成]ボタンをクリックし、[カスタマイズ設定]領域を展開して、 [カスタマイズ可能]ボタンをクリックします。](./personalizing-pages/images/01.png)

5.  カスタマイズ可能にするセクションごとに、「**カスタマイズ不可**]オプションを「**カスタマイズ可能**」に切り替えます。

## ページのカスタマイズ

ページのカスタマイズを有効にすると、サイトメンバーは右上の[追加]メニューからページのカスタマイズ可能なセクションにアプリを追加できます。 サイトメンバーは、カスタマイズ可能な領域に対して2種類のカスタマイズを行うことができます。

  - アプリを追加または削除する
  - アプリケーションを構成する

<!-- end list -->

```{note}
Site members can't change a non-instanceable app's configuration inside a customizable region since those apps are tied to the site they've been added to.
```

サイトメンバーは、コントロールメニューのページの[**オプション**]メニュー（![Options](../../../images/icon-options.png)）からこれらのコンテキストオプションにアクセスできます。

  - **カスタマイズなしでページを表示** ：デフォルトページを表示し、[追加]メニューを非表示にします。

  - **カスタマイズをリセット** ：カスタマイズされたページをデフォルトページに戻し、カスタマイズを破棄します。

  - **マイカスタマイズページの表示** ：ユーザーのカスタマイズを含むページを表示し、[追加]メニューを使用可能にして、ユーザーがウィジェットをページに追加できるようにします。

![ページ上でアプリを整理すると、カスタマイズ可能な領域が緑色で強調表示されます。](./personalizing-pages/images/02.png)

カスタマイズ可能なページの管理者には、サイトメンバーと同じ2つのビューがあります **デフォルトのページ** ビュー、 **カスタマイズされたページ** ビューです。 彼らは、デフォルトのページのカスタマイズできないセクションに加えた変更は、カスタマイズのセクションに加えた変更のみが影響を与える自分自身と行うのに対し、単に他のページのようにすべてのユーザーに影響を与え **ない** 、上書き、ユーザーのカスタマイズを。

## ページをカスタマイズするためのロール許可の付与

デフォルトでは、サイトメンバーはページのカスタマイズを行うことができますが、サイト以外のメンバーとゲストは行うことができません。 管理者は、既存のロールの権限を更新するか、 [を指定して新しいロール](../../../users-and-permissions/roles-and-permissions/creating-and-managing-roles.md) を作成し、それを他のユーザーに割り当てて、ページをカスタマイズできるようにすることができます。 次の手順に従って、ページをカスタマイズするためのロール権限を付与します。

1.  製品メニューを開き、 [**コントロールパネル**] → [**ユーザー**] → [**ロール**] に移動します。

2.  役割の[Actions]メニューを開き、[**Edit**]を選択します。

3.  役割の[**権限の定義**]タブをクリックし、[概要]で[**サイト管理** →[**サイトビルダー** →[**ページ**]します。

4. **Resource Permissions** 見出しの下のPageセクションまでスクロールし、 **Customize** 権限を確認します。

5.  下にスクロールして、[**保存**]をクリックして変更を適用します。

<!-- end list -->

```{note}
The *Customize* permission also lets users customize the look and feel of apps and import or export app settings.
```

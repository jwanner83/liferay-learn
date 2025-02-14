# Managing Translation Permissions

The required permissions for translating Content Pages and Web Content depend on the translation method:

* Manual translation requires either *Update* permissions for the resource type, or *Translate* permissions for one or more languages.

* Exporting and importing translations requires *Update* permissions for the resource type.

## Assigning Update Permissions

Users with *Update* permissions for Pages and Web Content can manually translate them into any available language. They can also export them as XLIFF files for translation and then import the translations when finished. See [Defining Role Permissions](../../users-and-permissions/roles-and-permissions/defining-role-permissions.md) to learn how to assign these permissions at the application level.

## Assigning Translate Permissions

Translate permissions are language specific and grant access to the *Translate* action for Content Pages and Web Content. Users with Translate permissions can only use languages they've been assigned. Once granted, these permissions cannot be restricted by individual assets.

```{note}
The languages available for translation are determined by your instance's localization settings. See [Initial Instance Localization](../../installation-and-upgrades/setting-up-liferay/initial-instance-localization.md) and [Virtual Instance Localization](../../system-administration/configuring-liferay/virtual-instances/localization.md) for more information.
```

Follow these steps to assign Translate permissions for specific languages:

1. Open the *Global Menu* ( ![Global Menu](../../images/icon-applications-menu.png) ), go to the *Control Panel* tab, and click *Roles*.

1. Click the *Actions* button ( ![Actions Button](../../images/icon-actions.png) ) for the desired role and select *Edit*.

   Alternatively, you can click the *Add* button ( ![Add Button](../../images/icon-add.png) ) to create a new role for translations.

1. Click the *Define Permissions* tab and go to *Site and Asset Library Administration* &rarr; *Configuration* &rarr; *Translation* in the permissions sidebar menu.

1. Use the checkboxes to assign the desired language permissions to the selected role.

   ![Assign the desired language permissions to the selected Role.](./managing-translation-permissions/images/01.png)

1. Click *Save* at the bottom of the page.

Users with the configured role can now manually translate Web Content and Content Page experiences into the specified languages.

## Additional Information

* [Translating Content Pages](./translating-content-pages.md)
* [Translating Web Content](./translating-web-content.md)

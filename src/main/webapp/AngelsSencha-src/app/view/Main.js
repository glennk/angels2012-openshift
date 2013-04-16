Ext.define('AngelsSencha.view.Main', {
    extend: 'Ext.tab.Panel',
    xtype: 'mainpanel',
    config: {
        tabBarPosition: 'bottom',
        items: [
            {
                title: 'Home',
                iconCls: 'home',
                html: [
                    '<div><center><img src="resources/icons/Angels2012.png" />',
                    '<h1>Welcome to Austin Angels 2013</h1>',
                    '<br/><h2>General Manager: David Zapata</h2>',
                    '<h2>info@austinangelsbaseball.com</h2>',
                    '<h2>512-555-1212</h2>',
                    '</center></div>'
                ].join("")
            },
            {
                xclass: 'AngelsSencha.view.TeamNav'
            },
            {
                xclass: 'AngelsSencha.view.PlayerNav'
            },
            {
                title: 'Contact',
                iconCls: 'user',
                xtype: 'formpanel',
                url: 'contact.php',
                layout: 'vbox',
                items: [
                    {
                        xtype: 'fieldset',
                        title: 'Contact Us',
                        instructions: '(email address is optional)',
                        items: [
                            {
                                xtype: 'textfield',
                                label: 'Name'
                            },
                            {
                                xtype: 'emailfield',
                                label: 'Email'
                            },
                            {
                                xtype: 'textareafield',
                                label: 'Message'
                            }
                        ]
                    },
                    {
                        xtype: 'button',
                        text: 'Send',
                        ui: 'confirm',
                        handler: function() {
                            this.up('formpanel').submit();
                        }
                    }
                ]
            }
        ]
    }
});

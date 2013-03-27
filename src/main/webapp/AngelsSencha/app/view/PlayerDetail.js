Ext.define('AngelsSencha.view.PlayerDetail', {
    extend: 'Ext.Panel',
    
    xtype: 'playerdetail',
    
    config: {
        styleHtmlContent: true,
        scrollable: 'vertical',
        tpl : [
                    '<img style="width: 100%;" src="resources/{level}.png" />',
                    '<h3>#{number}&nbsp; {firstname} {lastname}</h3>',
                    '<h4>Nickname: {nickname}</h4>',
                    '<img style="width: 100%;" src="http://localhost:8080/myproj/rest/player/{idplayers}/photo"/>'
                ].join("")
    }
});

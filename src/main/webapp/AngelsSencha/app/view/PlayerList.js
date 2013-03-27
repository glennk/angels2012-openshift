Ext.define('AngelsSencha.view.PlayerList', {
    
    extend: 'Ext.List',
    xtype: 'playerlist',
    
    requires: ['AngelsSencha.store.Players'],
    
    config: {
        title: 'Angel Players',
        itemTpl: '#{number} {firstname} {lastname} <span style="small"> {level} </small>',
        store: 'playerstore',
        grouped: true,
        indexBar: true,
        onItemDisclosure: true,
    }
});

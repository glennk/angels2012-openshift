Ext.define('AngelsSencha.view.TeamList', {
    
    extend: 'Ext.List',
    xtype: 'teamlist',
    
    requires: ['AngelsSencha.store.Teams'],
    
    config: {
        title: 'Teams',
        itemTpl: '{name} {xlevel}',
        store: 'teamstore',
        onItemDisclosure: true,
    }
});

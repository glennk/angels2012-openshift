Ext.define('AngelsSencha.store.Players', {
    extend: 'Ext.data.Store',
    
    config: {
        storeId: 'playerstore',
        model: 'AngelsSencha.model.Player',
        sorters: 'lastname',
        grouper: function(record) {
            return record.get('lastname')[0];
        },
        autoLoad: true,
        proxy: {
            type: "ajax",
            url: "/rest/player",
//            url: "resources/data/players.json",
            reader: {
                type: "json",
                rootProperty: ""
            }
        },

    },
});

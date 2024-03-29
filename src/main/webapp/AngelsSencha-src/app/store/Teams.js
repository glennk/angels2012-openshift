Ext.define('AngelsSencha.store.Teams', {
    extend: 'Ext.data.Store',
    config: {
        storeId: 'teamstore',
        model: 'AngelsSencha.model.Team',
//        data:
//                [
//                    {idteams: "7", name: "Austin Angels 11U", level: "11UW"},
//                    {idteams: "5", name: "Austin Angels 12U", level: "12UW"},
//                    {idteams: "3", name: "Austin Angels 13U Red", level: "13UR"}
//                ]
        autoLoad: true,
        proxy: {
            type: "ajax",
            url: "http://localhost:8080/myproj/rest/team",
//            url: "resources/data/teams.json",
            reader: {
                type: "json",
                rootProperty: ""
            }
        },
    }
});

Ext.define('AngelsSencha.model.Player', {
    extend: 'Ext.data.Model',
    
    config: {
        fields: [
          'idplayers', 
          'number',
          'firstname',
          'lastname',
          'nickname',
          { name: 'idteams', mapping: 'teamsId.idteams' },
          { name: 'level', mapping: 'teamsId.level' }
        ],
//        hasOne: {
//            model: "Team",
//            name: "teamsId"
//        },  
    },
    
    fullName: function() {
        var d = this.data,
        names = [
            d.firstname,
            d.lastname,
        ];
        return names.join(" ");
    }
    
});

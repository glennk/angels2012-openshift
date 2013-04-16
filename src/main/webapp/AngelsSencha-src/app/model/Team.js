Ext.define('AngelsSencha.model.Team', {
    extend: 'Ext.data.Model',
    
    config: {
        fields: ['idteams', 'name', 'level']
    },
    
    fullName: function() {
        var d = this.data,
        names = [
            d.name,
            d.level
        ];
        return names.join(" ");
    }
    
});

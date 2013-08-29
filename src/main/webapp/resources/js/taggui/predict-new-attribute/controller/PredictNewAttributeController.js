Ext.define('TAGGUI.predict-new-attribute.controller.PredictNewAttributeController', {
    extend: 'Ext.app.Controller',

    views: [
        'PredictNewAttributePanel'
    ],

    init: function () {

        this.control({

            'predict-new-attribute-view': {
                beforerender: this.beforeRenderView
            }

        });

    },

    beforeRenderView: function (component, eOpts) {
        AIDRFMFunctions.initMessageContainer();

        this.mainComponent = component;
        predictNewAttributeController = this;

        var me = this;

        this.getAttributesForCrises();
    },

    getAttributesForCrises: function() {
        var me = this;

        Ext.Ajax.request({
            url: BASE_URL + '/protected/tagger/getAttributesForCrises.action',
            method: 'GET',
            params: {
                id: COLLECTION_ID
            },
            headers: {
                'Accept': 'application/json'
            },
            success: function (response) {
                var resp = Ext.decode(response.responseText);
                if (resp.success && resp.data) {
                    var count = resp.data.length;
                    if (count > 0) {
                        var standard = [],
                            custom = [];
                        Ext.Array.each(resp.data, function(r, index) {
                            if (r.userID) {
                                if (r.userID == 1) {
                                    delete r.userID;
                                    standard.push(r);
                                } else {
                                    delete r.userID;
                                    custom.push(r);
                                }
                            }
                        });

                        if (standard.length > 0 && custom.length > 0){
                            me.mainComponent.emptySpace.show();
                        } else {
                            me.mainComponent.emptySpace.hide();
                        }

                        me.mainComponent.standardAttributesStore.loadData(standard);
                        me.mainComponent.customAttributesStore.loadData(custom);
                    }
                } else {
                    AIDRFMFunctions.setAlert("Error", resp.message);
                }
            },
            failure: function () {
                AIDRFMFunctions.setAlert("Error", "System is down or under maintenance. For further inquiries please contact admin.");
            }
        });
    },

    addAttributeToCrises: function(id) {
        var me = this;
        alert("From add attribute for crises");
    }

});
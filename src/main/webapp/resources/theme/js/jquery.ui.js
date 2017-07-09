! function(t, window) {
    var n = {
            collection: null,
            init: function() {
                n.collection = t(".fullscreen"), n.render()
            },
            render: function() {
                n.collection.each(function() {
                if (t(this) !== null)
                    t(this).css("height", window.height())
                })
            }
        },
        o = function() {
            n.init()
        },
        c = function() {
            n.render()
        };
    window.on("load", o).on("resize", c)
}(jQuery, jQuery(window));
$(document).ready(function(){
    var accordionIcons = {
      header: "ui-icon-circle-plus",
      activeHeader: "ui-icon-circle-minus"
    };
    $(".collapsiblePanel").accordion({
        active: false,
        collapsible: true,        
        icons:accordionIcons
    });
});  


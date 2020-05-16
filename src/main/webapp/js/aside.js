
$(".first-bar>li").on("click", function() {
    let this_child = $(this).children("ul");
    $(this).children("ul").removeClass("not-active").addClass("active");
    $(".active").not(this_child).removeClass("active").addClass("not-active");
});

$(".second-bar>a").on("click",function () {
    let this_li = $(this).children("li");
    $(this_li).addClass("li-active");
    $(".li-active").not(this_li).removeClass("li-active");
});
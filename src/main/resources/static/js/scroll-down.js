document.addEventListener("DOMContentLoaded", function () {
    var scrollButton = document.getElementById("scrollButton");
    scrollButton.addEventListener("click", function () {
        // Scroll to the end of the page
        window.scrollTo(0, document.body.scrollHeight);
    });
});
function follow(event) {
    var followBtn = document.getElementById("follow-id");
    var followerId = followBtn.dataset.id;
    $.ajax({
        url: "/ajax/followUser",
        type: "post",
        data: {
            "follower": followerId
        },
        success: function (data) {
            followBtn.disable();
            followBtn.value = "Followed";
        }
    })
}
function follow(event) {
    var follower = event.target.id;
    $.ajax({
        url: "/ajax/followUser",
        type: "post",
        data: {
            "follower": follower
        },
        success: function (followerId) {
            // var followDiv = document.getElementById("div" + followerId);
            var followButton = document.getElementById(followerId);
            followButton.value = "Followed";
            // followDiv.remove();
        }
    })
}
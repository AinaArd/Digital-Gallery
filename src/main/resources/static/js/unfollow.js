function unfollow(event) {
    var followingId = event.target.id;
    $.ajax({
        url: "/ajax/unfollowUser",
        type: "post",
        data: {
            "followingId": followingId
        },
        success: function(){

        }
    })
}
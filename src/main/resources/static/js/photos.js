function like(event) {
    var photoId = event.target.id;
    $.ajax({
        url: "/ajax/like",
        type: "post",
        data: {
            "id": photoId
        },
        success: function (photoId) {
            var likes = document.getElementById("like" + photoId);
            likes.innerHTML = +likes.innerHTML + 1;
        }
    })
}

function deletePhoto(event) {
    var photoId = event.target.id;
    $.ajax({
        url: "/ajax/delete",
        type: "post",
        data: {
            "id": photoId
        },
        success: function (photo) {
            var photoLi = document.getElementById("li" + photo);
            photoLi.remove();
        }
    })
} 
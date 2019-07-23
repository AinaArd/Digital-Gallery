function commentPhoto(event) {
    var photoId = event.target.id;
    var comment = document.getElementById("comment");
    var ul = document.getElementById("ul-id" + photoId);

    if (comment.value.length > 0) {
        $.ajax({
            url: "/ajax/addComment",
            type: "post",
            data: {
                "id": photoId,
                "comment": comment.value
            },
            success: function (data) {
                var element = document.createElement("li");
                var a = document.createElement("a");
                var text = document.createElement("b");

                a.href = "/profile";
                a.innerHTML = data.author + ": ";

                text.innerHTML = data.commentText;

                element.appendChild(a);
                element.appendChild(text);
                ul.appendChild(element);

                comment.value = "";
            }
        })
    } else
        alert("Comment can't be empty! Write something in the form")
}
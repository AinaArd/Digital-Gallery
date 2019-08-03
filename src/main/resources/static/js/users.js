function addParticipants() {
    var search = document.getElementById("search");
    var result = document.getElementById("user-candidates");
    var gallery = document.getElementById("gallery-id");
    var members = document.getElementById("member");
    var galleryId = gallery.dataset.id;
    if (search.value.length > 0) {
        $.ajax({
            url: "/ajax/inviteUsersToGallery",
            type: "post",
            data: {
                "search": search.value
            },
            success: function (userCandidates) {
                result.innerText = "";
                for (var user in userCandidates) {
                    var textNode = document.createElement("p");

                    var buttonAdd = document.createElement("button");
                    buttonAdd.innerText = "Add";
                    buttonAdd.className = 'button-add';
                    buttonAdd.onclick = function add() {

                        buttonAdd.innerHTML = "Added";
                        var userName = userCandidates[user].name;

                        $.ajax({
                                url: "/ajax/addParticipant",
                                type: "post",
                                data: {
                                    "userName": userName,
                                    "galleryId": galleryId
                                },
                                success: function (user) {
                                    console.log(user.name);
                                    var a = document.createElement("a");

                                    a.href = "../profile/" + user.id;
                                    a.innerHTML = user.name + " ";

                                    var br = document.createElement("br");

                                    members.appendChild(a);
                                    members.insertBefore(br, a);
                                }
                            }
                        )
                    };

                    var a = document.createElement("a");
                    a.href = "../profile/" + userCandidates[user].id;
                    a.innerHTML = userCandidates[user].name;

                    textNode.appendChild(buttonAdd);
                    textNode.appendChild(a);
                    result.appendChild(textNode);
                }
            },
            error: function (msg) {
                alert(msg);
            }
        })
    } else {
        result.innerHTML = "";
    }
}

function add() {

}
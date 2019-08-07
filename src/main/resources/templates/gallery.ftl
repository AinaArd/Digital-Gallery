<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700,800|Playfair+Display:,300, 400, 700"
          rel="stylesheet">
    <link href="/css/photoStyles.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/animate.css">
    <link rel="stylesheet" href="/css/owl.carousel.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/mediaelement@4.2.7/build/mediaelementplayer.min.css">

    <link rel="stylesheet" href="/fonts/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="/fonts/fontawesome/css/font-awesome.min.css">


    <!-- Theme Style -->
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/profileStyle.css">
</head>
<body>

<div class="site-wrap">

    <a href="#" class="offcanvas-toggle js-offcanvas-toggle">Menu</a>
    <#include "menu.ftl">

    <main>
        <a href="/profile" class="home-button"></a>
        <h1 id="gallery-id" data-id="${gallery.id}" class="mb-5">${gallery.name}</h1>


        <ul>
            <#if gallery.editors??>
                Editors:
                <#list gallery.editors as editor>
                    <a href="/profile/${editor.id}">${editor.name}</a>
                </#list>
            <#else>
                No editors in this gallery
            </#if>
        </ul>

        <#if user??>
            <input class="btn-gallery" type="submit" id="${gallery.id}" onclick="show(document.getElementById('addParticipants'))"
                   value="Add participants">
        </#if>
        <br>
        <br>

        <div style="display: none;" id="addParticipants">
            <div id="div-users">
                <label for="search">Add
                    <input id="search" oninput="addParticipants(event)">
                </label>
                <div id="result"></div>
                <br>
                <br>
                <div id="user-candidates"></div>
            </div>

        </div>
        <br>

        <div class="mb-5">
            <ul>
                <#if gallery.photos??>
                    <#list gallery.photos as photo>
                        <li id="li${photo.id}">
                            ${photo.name}
                            <br>
                            Description: ${photo.description}
                            <br>
                            <img class="img-thumbnail" src="/load/${photo.getPhotoPath()}"
                                 alt="">
                            <br>
                            <br>
                            <i id="like${photo.id}">${photo.likes}</i>&nbsp;Likes
                            <br>
                            <br>
                            <button class="btn-gallery" id="${photo.id}" onclick="like(event)">Like</button>
                            <button class="btn-gallery" id="${photo.id}" onclick="deletePhoto(event)">Delete</button>
                            <div>
                                <#if photo.comments??>
                                    <ul id="ul-id${photo.id}">
                                        <#list photo.comments as comment>
                                            <li style="list-style-type: none;">
                                                <a href="/profile/${comment.author.id}">${comment.author.name}: </a>

                                                <b data-contain-user-tags>${comment.content}</b>
                                            </li>
                                        </#list>
                                    </ul>
                                </#if>
                                <div class="card my-4">
                                    <h5 class="card-header">Leave a Comment:</h5>
                                    <div class="card-body">
                                        <div class="form-group">
                                            <textarea class="form-control" id="comment" name="comment"
                                                      rows="3"></textarea>
                                        </div>
                                        <button class="btn-gallery" type="submit" onclick="commentPhoto(event)" id="${photo.id}"
                                                name="comment-btn">Comment</button>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <br>
                    </#list>
                </#if>
            </ul>

            <#if user??>
                <br>
                <input class="btn-gallery" type="submit" value="Add photo" onclick="show(document.getElementById('addPhoto'))""/>
                <br>
                <br>
            </#if>

            <form method="post" id="addPhoto" style="display: none;" enctype="multipart/form-data">
                <div class="add-photo">Add photo</div>
                <label for="name">Name
                    <input class="input-field" type="text" id="name" name="name">
                </label>
                <label for="text">Description
                    <input class="textarea-field" id="description" name="description">
                </label>

                <input type="file" name="file" id="file">
                <br>
                <br>
                <input type="submit" class="btn-gallery" value="Add"/>
            </form

        </div>

    </main>
</div>

<!-- loader -->
<div id="loader" class="show fullscreen">
    <svg class="circular" width="48px" height="48px">
        <circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"></circle>
        <circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10"
                stroke="#f4b214"></circle>
    </svg>
</div>

<script>
    function show(div) {
        if (div.style.display === "none") {
            div.style.display = "block";
        } else
            div.style.display = "none"
    }
</script>
<script src="/js/jquery-3.2.1.min.js"></script>
<script src="/js/popper.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/owl.carousel.min.js"></script>
<script src="/js/jquery.waypoints.min.js"></script>
<script src="/js/jquery.countdown.min.js"></script>
<script src="/js/main.js"></script>
<script type="application/javascript" src="/js/photos.js"></script>
<script type="application/javascript" src="/js/users.js"></script>
<script type="application/javascript" src="/js/comments.js"></script>
<script src="https://code.jquery.com/jquery-migrate-1.4.1.min.js"></script>

</body>
</html>
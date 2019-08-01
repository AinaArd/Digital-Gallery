<#--<html>-->
<#--<head>-->
<#--    <link href="/css/bootstrap.min.css" rel="stylesheet">-->
<#--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">-->
<#--    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>-->
<#--    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>-->
<#--    <script src="//ajax.aspnetcdn.com/ajax/jquery.ui/1.10.3/jquery-ui.min.js"></script>-->
<#--    <link rel="stylesheet" href="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.10.3/themes/sunny/jquery-ui.css">-->
<#--    <link href="/css/photoStyles.css" rel="stylesheet" type="text/css">-->
<#--    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700,800|Playfair+Display:,300, 400, 700"-->
<#--          rel="stylesheet">-->

<#--    <link rel="stylesheet" href="css/animate.css">-->
<#--    <link rel="stylesheet" href="css/owl.carousel.min.css">-->
<#--    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/mediaelement@4.2.7/build/mediaelementplayer.min.css">-->

<#--    <link rel="stylesheet" href="fonts/ionicons/css/ionicons.min.css">-->
<#--    <link rel="stylesheet" href="fonts/fontawesome/css/font-awesome.min.css">-->

<#--    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>-->
<#--</head>-->

<#--${gallery.name}-->
<#--<body>-->
<#--<div class="site-wrap">-->
<#--    <a href="#" class="offcanvas-toggle js-offcanvas-toggle">Menu</a>-->
<#--    <#include "menu.ftl">-->

<#--    <ul>-->
<#--        <#if gallery.photos??>-->
<#--            <#list gallery.photos as photo>-->
<#--                <li id="li${photo.id}">-->
<#--                    ${photo.name}-->
<#--                    <br>-->
<#--                    <img class="pic img-thumbnail" src="/load/${photo.getPhotoPath()}"-->
<#--                         alt="">-->
<#--                    <br>-->
<#--                    <i id="like${photo.id}">${photo.likes}</i>&nbsp;Likes-->
<#--                    <br>-->
<#--                    <button id="${photo.id}" onclick="like(event)">Like</button>-->
<#--                    <button id="${photo.id}" onclick="deletePhoto(event)">Delete</button>-->
<#--                </li>-->
<#--                <br>-->
<#--            </#list>-->
<#--        </#if>-->
<#--    </ul>-->

<#--    <br>-->
<#--    <input type="submit" value="Add photo" onclick="show(document.getElementById('addPhoto'))""/>-->
<#--    <br>-->
<#--    <br>-->

<#--    <form method="post" id="addPhoto" style="display: none;" enctype="multipart/form-data">-->
<#--        <div class="add-photo">Add photo</div>-->
<#--        <label for="name">Name-->
<#--            <input class="input-field" type="text" id="name" name="name">-->
<#--        </label>-->
<#--        <label for="text">Description-->
<#--            <input class="textarea-field" id="description" name="description">-->
<#--        </label>-->

<#--        <input type="file" name="file" id="file">-->
<#--        <br>-->
<#--        <input type="submit" value="Add"/>-->
<#--    </form>-->
<#--</div>-->

<#--<script>-->
<#--    function show(div) {-->
<#--        if (div.style.display === "none") {-->
<#--            div.style.display = "block";-->
<#--        } else-->
<#--            div.style.display = "none"-->
<#--    }-->
<#--</script>-->
<#--<script src="https://code.jquery.com/jquery-migrate-1.4.1.min.js"></script>-->
<#--<script type="application/javascript" src="/js/photos.js"></script>-->
<#--</body>-->
<#--</html>-->

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
</head>
<body>

<div class="site-wrap">

    <a href="#" class="offcanvas-toggle js-offcanvas-toggle">Menu</a>
    <#include "menu.ftl">

    <main>
        <a href="index.html" class="home-button"></a>
        <h1 class="mb-5">${gallery.name}</h1>

        <#if add??>
            <input type="submit" id="${gallery.id}" onclick="show(document.getElementById('addParticipants'))"
                   value="Add participants">
        </#if>
        <br>

        <form style="display: none;" method="post" id="addParticipants">
            <ul>
                <#if gallery.owner.followers??>
                    <#list gallery.owner.followers as follower>
                        <div>
                            <a href="/profile/${follower.id}">${follower.name}</a>
                            &nbsp;
                            <input value="Add" id="${follower.id}" onclick="addParticipant(event)">
                        </div>
                    </#list>
                </#if>
            </ul>
        </form>
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
                            <i id="like${photo.id}">${photo.likes}</i>&nbsp;Likes
                            <br>
                            <button id="${photo.id}" onclick="like(event)">Like</button>
                            <button id="${photo.id}" onclick="deletePhoto(event)">Delete</button>
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
                                        <button type="submit" onclick="commentPhoto(event)" id="${photo.id}"
                                                name="comment-btn"
                                                class="button-add">Comment
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <br>
                    </#list>
                </#if>
            </ul>

            <br>
            <input type="submit" value="Add photo" onclick="show(document.getElementById('addPhoto'))""/>
            <br>
            <br>

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
                <input type="submit" value="Add"/>
            </form>
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
<script type="application/javascript" src="/js/comments.js"></script>
<script src="https://code.jquery.com/jquery-migrate-1.4.1.min.js"></script>

</body>
</html>
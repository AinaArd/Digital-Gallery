<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700,800|Playfair+Display:,300, 400, 700"
          rel="stylesheet">

    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/animate.css">
    <link rel="stylesheet" href="/css/owl.carousel.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/mediaelement@4.2.7/build/mediaelementplayer.min.css">

    <link rel="stylesheet" href="/fonts/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="/fonts/fontawesome/css/font-awesome.min.css">

    <link href="css/main.css" rel="stylesheet" media="all">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

    <!-- Theme Style -->
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/profileStyle.css">
</head>
<body>

<div class="site-wrap profile">

    <a href="#" class="offcanvas-toggle js-offcanvas-toggle">Menu</a>
    <#include "menu.ftl">

    <aside>
        <#if picture ??>
            <img class="img-thumbnail" src="/load/${user.getPicturePath()}" alt="">
        <#else>
            <img class="img-thumbnail" src="/images/img_1.jpg" alt="">
        </#if>
    </aside>
    <main>
        <h1 class="mb-0">Hi, I'm ${user.name}</h1>
        <div class="mb-5">
            <p class="lead mb-3" style="color: #000000">Web Designer &amp; Developer</p>
            <br>
            <#if user.description??>
                <p>${user.description}</p>
            </#if>
            <br>
            <ul>
                <#if user.galleries??>
                    As editor in:
                    <#list user.galleries as editorGallery>
                        <li><a href="/gallery/${editorGallery.id}">${editorGallery.name}</a></li>
                    </#list>
                </#if>
            </ul>
        </div>

        <#if otherUser??>
            <#if followed??>
                <div id="div${user.id}">
                    <input type="button" id="unfollow-id" data-id="${user.id}" class="btn-gallery" value="Unfollow" onclick="unfollow(event)">
                </div>
            <#elseif notfollowed??>
                <div id="div${user.id}">
                    <input type="button" class="btn-gallery" id="follow-id" data-id="${user.id}" value="Follow" onclick="follow(event)">
                </div>
            </#if>
        </#if>

        <br>
        <#if otherUser??>
        <#else>
            <label for="add-description">
                <input type="submit" id="add-description" name="add-description" value="Add description"
                       onclick="show(document.getElementById('description-form'))"/>
            </label>
            <br>
            <label for="edit-photo">
                <input type="submit" id="edit-photo" name="edit-photo" value="Change photo"
                       onclick="show(document.getElementById('user-photo'))"/>
            </label>
            <br>
            <br>
        </#if>

        <form method="post" style="display: none;" id="description-form">
            <div class="form-group">
                <textarea class="form-control" id="description" name="description" rows="3"></textarea>
            </div>
            <input name="description" type="submit" value="Save"/>
        </form>

        <br>
        <br>

        <form method="post" style="display: none;" id="user-photo" enctype="multipart/form-data">
            <input type="file" name="photo" id="photo">
            <br>
            <input type="submit" name="photo" value="Save"/>
        </form>

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
<script type="application/javascript" src="/js/jquery-3.2.1.min.js"></script>
<script type="application/javascript" src="/js/popper.min.js"></script>
<script type="application/javascript" src="/js/bootstrap.min.js"></script>
<script type="application/javascript" src="/js/owl.carousel.min.js"></script>
<script type="application/javascript" src="/js/jquery.waypoints.min.js"></script>
<script type="application/javascript" src="/js/jquery.countdown.min.js"></script>
<script type="application/javascript" src="/js/main.js"></script>
<script type="application/javascript" src="/js/follow.js"></script>
</body>
</html>
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


    <!-- Theme Style -->
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>

<div class="site-wrap">

    <a href="#" class="offcanvas-toggle js-offcanvas-toggle">Menu</a>
    <#include "menu.ftl">

    <aside style="background-image: url(../images/profile_big.jpg);"></aside>
    <main>
        <h1 class="mb-0">Hi, I'm ${user.name}</h1>
        <div class="mb-5">
            <p class="lead mb-3">Web Designer &amp; Developer</p>
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
                <button disabled>Followed</button>
            <#else>
                <div id="div${user.id}">
                    <input type="button" id="${user.id}" value="Follow" onclick="follow(event)">
                </div>
            </#if>
        </#if>

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
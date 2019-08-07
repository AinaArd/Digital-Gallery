<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700,800|Playfair+Display:,300, 400, 700"
          rel="stylesheet">

    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/animate.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/mediaelement@4.2.7/build/mediaelementplayer.min.css">

    <link rel="stylesheet" href="fonts/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="fonts/fontawesome/css/font-awesome.min.css">


    <!-- Theme Style -->
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="site-wrap">

    <a href="#" class="offcanvas-toggle js-offcanvas-toggle">Menu</a>
    <#include "menu.ftl">

    <main style="display: inline">
        <a href="/profile" class="home-button"><span class="fa fa-home"></span></a>
        <h1 class="mb-5">Followings</h1>
        <div class="mb-5">
            <ul class="resume-list">
                <#if user.followings??>
                    <#list user.followings as following>
                        <li>
                            <h3><a href="/profile/${following.id}">${following.name}</a></h3>
                            <p class="date">Login: ${following.login}</p>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sint dolorum dolore culpa
                                libero
                                delectus excepturi! Repellat dolore, sapiente officia quod.</p>
                            <button id="${following.id}" onclick="unfollow(event)">Unfollow</button>
                        </li>
                    </#list>
                </#if>
            </ul>
        </div>


        <h1 class="mb-5">Followers</h1>
        <div class="mb-5">
            <ul class="resume-list">
                <#if user.followers??>
                    <#list user.followers as follower>
                        <li>
                            <h3><a href="/profile/${follower.id}">${follower.name}</a></h3>
                            <p class="date">Login: ${follower.login}</p>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sint dolorum dolore culpa
                                libero
                                delectus excepturi! Repellat dolore, sapiente officia quod.</p>
                            <button id="${follower.id}" onclick="unfollow(event )">Unfollow</button>
                        </li>
                    </#list>
                </#if>
            </ul>
        </div>

    </main>
</div>

<!-- loader -->
<div id="loader" class="show fullscreen">
    <svg class="circular" width="48px" height="48px">
        <circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/>
        <circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10"
                stroke="#f4b214"/>
    </svg>
</div>

<script src="/js/jquery-3.2.1.min.js"></script>
<script src="/js/popper.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/owl.carousel.min.js"></script>
<script src="/js/jquery.waypoints.min.js"></script>
<script src="/js/jquery.countdown.min.js"></script>
<script src="/js/main.js"></script>
<script src="/js/unfollow.js"></script>

</body>
</html>
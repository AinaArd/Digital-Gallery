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

    <main>
        <a href="/profile" class="home-button"><span class="fa fa-home"></span></a>
        <h1 class="mb-5">Portfolio</h1>
        <div class="mb-5">
            <ul class="portfolio-list">
                <#if user.ownGalleries??>
                    <#list user.ownGalleries as gallery>
                        <li>
                            <a href="/gallery/${gallery.id}">
                                <img src="../images/done.png" alt="">
                                <div class="text">
                                    <h3>${gallery.name}</h3>
                                    <span>Visit Website</span>
                                </div>
                            </a>
                        </li>
                    <#--<li>
                        <a href="#">
                            <img src="../images/img_2.jpg" alt="">
                            <div class="text">
                                <h3>Project Name</h3>
                                <span>Visit Website</span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <img src="../images/img_3.jpg" alt="">
                            <div class="text">
                                <h3>Project Name</h3>
                                <span>Visit Website</span>
                            </div>
                        </a>
                    </li>-->
                    </#list>
                </#if>
            </ul>
        </div>

        <form method="post">Add new gallery
            <br>
            <label>Name
                <input name="name" type="text">
            </label>
            <input type="submit" value="Save">
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

<script src="/js/jquery-3.2.1.min.js"></script>
<script src="/js/popper.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/owl.carousel.min.js"></script>
<script src="/js/jquery.waypoints.min.js"></script>
<script src="/js/jquery.countdown.min.js"></script>
<script src="/js/main.js"></script>
<script src="https://code.jquery.com/jquery-migrate-1.4.1.min.js"></script>

</body>
</html>
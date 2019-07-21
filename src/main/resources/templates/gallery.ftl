<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="//ajax.aspnetcdn.com/ajax/jquery.ui/1.10.3/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.10.3/themes/sunny/jquery-ui.css">
    <link href="/css/photoStyles.css" rel="stylesheet" type="text/css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>

${gallery.name}
<body>
<ul>
    <#if gallery.photos??>
        <#list gallery.photos as photo>
            <li>
                ${photo.name}
                    <!-- Preview Image -->
                    <img class="pic img-thumbnail" style="width: 50%; height: 50%" src="/load/${photo.getPhotoPath()}" alt="">
            </li>
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
    <input type="submit" value="Add"/>
</form>

<script>
    function show(div) {
        if (div.style.display === "none") {
            div.style.display = "block";
        } else
            div.style.display = "none"
    }
</script>
<script src="https://code.jquery.com/jquery-migrate-1.4.1.min.js"></script>
</body>
</html>
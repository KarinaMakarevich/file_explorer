function openCreateModalWindow(fileName) {
    $('#win').removeAttr('style');
    $('#fileName').val('');
    $('.wrong-info').attr("style", "display:none");
    let button;
    button = $("#create-button");
    button.prop('value', fileName);
    button.removeAttr('style');
}

function closeModalWindow(id) {
    let divs = $('div');
    for (let i = 0; i < divs.length; i++) {
        if (divs[i].id === id) {
            divs[i].style.display = 'none';
        }
    }
}

function openQuestionModalWindow(fileName) {
    $('#del-file').removeAttr('style');
    $('#delete-button').prop('value', fileName);
    if (fileName.length > 70) {
        fileName = "..." + fileName.slice(-70, -47) + "\n" + fileName.slice(-47);
    }
    $('#file-for-del').html("Do you really want to delete " + fileName + "?");
}

function deleteFile(fileName) {
    $.ajax({
        url: "/deleteFile",
        type: "GET",
        data: {"deleteButton": fileName},
        dataType: "json",
        success: function (data) {
            let articles = $('article');
            for (let i = 0; i < articles.length; i++) {
                if (articles[i].id === fileName) {
                    articles[i].style.display = "none";
                }
            }
            $('#del-file').attr("style", "display:none");
            console.log(data);
        },
        error: function (xhr, status, error) {
            console.log("error" + xhr.responseText);
        }
    });
}

function createNewFile() {
    const file = $('#fileName').val();
    const fileType = $('#type').val();
    if (file.trim().length === 0) {
        event.preventDefault();
        $('#empty-file-name').removeAttr('style');
        return;
    }
    let folderName = $('#create-button').val().toString();
    if (folderName.length === 0) {
        folderName = $('#create-folder-button').val().toString();
    }
    let fileName;
    if ("\\" === folderName.slice(-1)) {
        fileName = folderName + $('#fileName').val();
    }
    else {
        fileName = folderName + "\\" + $('#fileName').val();
    }
    $.ajax({
        url: "/createFile",
        type: "GET",
        data: {"createButton": fileName, "type": fileType},
        dataType: "json",
        success: function (response) {
            console.log(response);
            /*$.each(response, function (key, value) {
                $('#forajaxxx').html(value);
            });*/
            $('#win').attr("style", "display:none");
            document.querySelector('#win').style.display = 'none';
        },
        error: function (xhr, status, error) {
            alert(status);
            alert(xhr.status);
            if (xhr.status == 200) {
                alert(status);
                window.location = "../../error/errorPage";
            }
            console.log(xhr.responseText);
        }
    });
}
var failedNote;

function closeNoty() {
    if (failedNote) {
        failedNote.close();
       /* failedNote = undefined;*/
    }
}

function successNoty(text) {
    closeNoty();
    new Noty({
        text: "<span class='glyphicon glyphicon-ok'></span> &nbsp;" + text,
        type: 'success',
        layout: "bottomRight",
        timeout: 1000
    }).show();
}

function failNoty(jqXHR) {
    closeNoty();
    new Noty({
        text: "<span class='glyphicon glyphicon-exclamation-sign'></span> &nbsp;Error status: " + jqXHR,
        type: "error",
        layout: "bottomRight"
    }).show();
}

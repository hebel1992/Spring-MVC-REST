//Wyswietlanie tytulow ksiazek

$.ajax({
    url: "http://localhost:8282/books",
    data: {},
    type: "GET",
    dataType: "json"
}).done(function (response) {
    displayTitles(response);
}).fail(function (err) {
    console.log(err)
})


function displayTitles(books) {
    books.forEach(function (book) {
        var title = $("<p>");
        var div = $("<div>");
        var revealButton = $("<button class='reveal' data-id=" + book.id + ">Pokaz szczegoly</button>");
        var deleteButton = $("<button class='delete' data-id=" + book.id + ">Usun</button>");
        title.text(book.title)
        $(".books").append(title);
        $(".books").append(revealButton);
        $(".books").append(div);
        $(".books").append(deleteButton);


    })
}

//Buttony rozwijajace divy ze szczegolami ksiazki

var section = $(".books");

section.on("click", "button.reveal", function () {
    var buttonId = $(this).attr("data-id");
    $.ajax({
        url: "http://localhost:8282/books/" + buttonId,
        data: {},
        type: "GET",
        dataType: "json"
    }).done(function (response) {
        bookInfo(response)
    }).fail(function (err) {
        console.log(err)
    })
})

function bookInfo(book) {
    var id = book.id;
    var button = $("button[data-id=" + id + "].reveal");

    var div = button.next();
    div.toggleClass("hide");
    if (div.hasClass("hide")){
        div.html("<div><strong>ID: </strong>" + book.id + ",</div> " +
            "<div><strong>ISBN:</strong> " + book.isbn + ",</div><div> <strong>tytul:</strong> " +
            book.title + ",</div><div><strong> author:</strong> " + book.author + ", </div><div><strong>publisher:</strong> " +
            book.publisher + ", </div><div><strong>type:</strong> " + book.type);}else {
        div.empty();
    }
}

//Buttony usuwajace ksiazke

section.on("click", "button.delete", function () {
    var buttonId = $(this).attr("data-id");
    $.ajax({
        url: "http://localhost:8282/books/" + buttonId,
        method: "DELETE"
    }).done(function (response) {
        console.log("deleted")
        window.location.reload();
    }).fail(function (err) {
        console.log(err)
    })

})

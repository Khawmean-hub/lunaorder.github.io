

//   toggle sidbar
$(document).on('click', '.toggleSidebar', function () {
  $(".sidebar").toggle();
});

var settings = {
  url: "https://b2bdoc.herokuapp.com/doc_menu_home_r01",
  method: "POST",
  timeout: 0,
  headers: {
    "Content-Type": "application/json",
  },
  data: JSON.stringify({
    LIMIT: 17,
    OFFSET: 1,
  }),
};

$.ajax(settings).done(function (response) {
  console.log("API:", response);
  var html = "";
  var content = "";
  var tags = response.data.TAGS;
  var article = response.data.ARTICLES;
  for (let i = 0; i < tags.length; i++) {
    html +=
      '<div class="py-2"> <a  href="#" class="tg">' +
      tags[i].title +
      "</a><ul>";
    for (let j = 0; j < article.length; j++) {
      if (tags[i].id == article[j].tag_id) {
        html +=
          '<li><a href="#" class="tg1" data="' +
          article[j].id +
          '">' +
          article[j].title +
          "</a></li>";
      }
    }
    html += "</ul></div>";
  }
  $(".list").empty().append(html);

  var content = "";
  var newArrr = [];
  for (let i = 0; i < article.length; i++) {
    var title = "";
    for (let j = 0; j < tags.length; j++) {
      if (article[i].tag_id == tags[j].id) {
        title = tags[j].title;
      }
    }
    var obj = {
      id: article[i].id,
      tag_id: article[i].tag_id,
      tag_name: title,
      title: article[i].title,
    };

    newArrr.push(obj);
  }

  newArrr.sort((a, b) => a.tag_name.localeCompare(b.tag_name));

  for (let k = 0; k < newArrr.length; k++) {
    content +=
      "<tr><td><h6>" +
      newArrr[k].tag_name +
      "</h6></td>" +
      '<td><a href="#">' +
      newArrr[k].title +
      "</a></td></tr>";
  }

  $("#content").empty().append(content);
});
$("#content").show();
$(document).on("click", ".tg", function () {
  $("#content").hide();
  $("#showData").show();
  $(this).parent().find("ul").toggle();
});
//    second content
$(document).on("click", ".tg1", function () {
  $(this).attr("data");
  console.log("data-attribute", $(this).attr("data"));
  var settings = {
    url: "https://b2bdoc.herokuapp.com/doc_article_r01",
    method: "POST",
    timeout: 0,
    headers: {
      "Content-Type": "application/json",
    },
    data: JSON.stringify({
      ID: $(this).attr("data"),
    }),
  };

  $.ajax(settings).done(function (response) {
    var data = response.data.content_body;
    console.log("data", data);
    $("#showData").empty().append(data);
  });
});

//   first content
$(document).on('click', '.sContent', function () {
  $("#content").show();
  $("#showData").hide();
})
// text editor
tinymce.init({
  selector: "textarea#editor",
  skin: "bootstrap",
  plugins: "lists, link, image, media",
  toolbar:
    "h1 h2 bold italic strikethrough blockquote bullist numlist backcolor | link image media | removeformat help",
  menubar: false,
});
var settings = {
  url: "https://b2bdoc.herokuapp.com/doc_department_r001",
  method: "POST",
  timeout: 0,
};

$.ajax(settings).done(function (response) {
  console.log(response);
  var dp = response.data.REC;
  var rowDp = "";
  for (let i = 0; i < dp.length; i++) {
    rowDp += "<option>" + dp[i].dep_name + "</option>";
    console.log("Dp lg:", dp[i].dep_name);
  }
  $("#dp").append(rowDp);
});

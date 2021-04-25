// var CLIENTID = "42f6854dd8ed4408a4ad3a7b52303250";
// var CLIENTSECRET = "90cf7eab479e4773945085484f3c2df4";
// var CLIENTIDQ = "NDJmNjg1NGRkOGVkNDQwOGE0YWQzYTdiNTIzMDMyNTA=";
// var CLIENTSECREQ = ":OTBjZjdlYWI0NzllNDc3Mzk0NTA4NTQ4NGYzYzJkZjQ=";
// var REDIRECTURL = "https://www.spotify.com/us/home/";
// var scopes = "%2cugc-image-upload%2cuser-read-recently-played%2cuser-top-read%2cuser-read-playback-position%2cuser-read-playback-state%2cuser-modify-playback-state%2cuser-read-currently-playing%2capp-remote-control%2cstreaming%2cplaylist-modify-public%2cplaylist-modify-private%2cplaylist-read-private%2cplaylist-read-collaborative%2cuser-follow-modify%2cuser-follow-read%2cuser-library-modify%2cuser-library-read%2c";
// var refresh = "AQAzBYsvuKvMUj9bwTlghZal_d07EO9HHW4rblI-_aypVs31vJ89qdcHwwTmi0jfVJhQop9frRtilFFrFGaEU8-zdf9blr71qP8-BIWOzvgLxGY6pZi1ZGZWOSDqG7GrDmo";
var datatopsongs = '';
var user_token = "";
var user_id = "";
// function setup(){
//
//     var button = select('#topsongs');
//   	button.mousePressed(topsongs);
//
// }
function printtop(top) {
    console.log(top);
    // alert("hello")

    var title = "";
    var img = "";
    var artists = "";
    var trackuri = [];


    for (var i = 0; i < top.items.length; i++) {
        var title = top.items[i].name;
        var artists = "";

        for (var j = 0; j < top.items[i].artists.length; j++) {

            // artists += top.items[i].artists[j].name + ", ";
            // console.log(j);
            // console.log(top.items[i].artists.length);
            if (j < top.items[i].artists.length - 1) {
                artists += top.items[i].artists[j].name + ", ";

            } else {
                artists += top.items[i].artists[j].name;
            }

        }
        var img = top.items[i].album.images[1].url
        trackuri.push(top.items[i].uri);


        songprinter(title, img, artists, i);
        console.log(title);
        console.log(img);
        console.log(artists);

    }

    console.log(trackuri);

    playlistMaker(trackuri, "Top 50 Songs")

}

function playlistMaker(trackuri, name){
 var url = 'https://api.spotify.com/v1/users/' + user_id + '/playlists';
 fetch(url, {
    method: 'POST',
     headers: {
         'Authorization': 'Bearer ' + user_token,
         "Accept": "application/json",
         "Content-Type": "application/json"
     },
     body: '{"name": "' +name+ '","description": "My New Playlist","public": false}',
 }).then(response => {
     return response.json()
 }).then(data => {
     addSongs(data, trackuri);
 })

}

function addSongs(data, trackuri){
  id = data.id;
  console.log(trackuri.toString());

   var url = 'https://api.spotify.com/v1/playlists/' + id + '/tracks?uris=' + trackuri.toString();
   fetch(url, {
      method: 'POST',
       headers: {
           'Authorization': 'Bearer ' + user_token,
           "Accept": "application/json",
           "Content-Type": "application/json"
       },

   }).then(response => {
       return response.json()
   }).then(data => {
       console.log(data);
   })
   getRecs(id);

}
//https://cors-anywhere.herokuapp.com/
function getRecs(playlist_id){
  var url = 'https://dsa-app.herokuapp.com/v1/rec?id=' + playlist_id + '&auth=' + user_token;
  fetch(url, {
     method: 'GET',
     headers: {

         "Accept": "*/*",
         "Access-Control-Request-Method": "GET",

         "Access-Control-Allow-Origin": "*",
         "Accept": "application/json",
         "Content-Type": "application/json",
         "X-Requested-With" :"application/json",
     },





  }).then(response => {
return response.json()
  }).then(data => {
      console.log(data.uri)
      //playlistMaker(data.uri, "Alexander's Recommendations");
  })

}

// curl -X "POST"
// "https://api.spotify.com/v1/users/aksatl/playlists"
//  --data "{\"name\":\"New Playlist\",\"description\":\"New playlist description\",\"public\":false}"
//  -H "Accept: application/json"
//
//   -H "Content-Type: application/json"
//    -H "Authorization: Bearer BQAOQlVHOfo1NlAKiulwnB3_7PbX-0jP3_aC6L8yWT3pEUDsoIfWNSpSrlmXQmOKUHyjPnKJTRA230C3pZjQvYmJLs4sHfCl9_8tnxt20IkBKZ8Gz46LYyIzwOC2bfRwloT0jy2VW2wzhZ8zYLgNHmaZ97SdEvFFBFEE_Qt1cMCNrzD3HLT3JFbJSFZq-uUrRrceQi4_C2ozyHqtFCyvSBzBxgS9-chIKrJSAkA8nfyB8f2nIx803Gmu1o-wc-kuwyvTRqvkrCAqpauM7q8"
//
//




function token (token){
  user_token = token;
  console.log(user_token);
}

function userid(ide){
  user_id = ide.id;
  console.log(ide);
}

function songprinter(title, img, artists, i) {
    //   var element = document.createElement("div");
    //   element.appendChild(document.createTextNode('The man who mistook his wife for a hat'));
    //   document.getElementById('lc').appendChild(element);
    //
    //
    //   var div = document.createElement('div');
    // div.classList.add('test');
    // var text = document.createTextNode('Test');
    // div.appendChild(text);
    // document.body.appendChild(div)


    var list = document.getElementById("list");
    var container = document.createElement("li");
    container.classList.add('container');
    container.setAttribute("id", "container" + i);
    document.getElementById('list').appendChild(container);

    var number = document.createElement("div");
    number.classList.add('number');
    number.setAttribute("id", "number " + (i + 1));
    number.innerHTML = (i + 1);
    document.getElementById("container" + i).appendChild(number);

    var imgcontainer = document.createElement("div");
    imgcontainer.classList.add('img-container');
    imgcontainer.setAttribute("id", "imgcontainer" + i);
    document.getElementById("container" + i).appendChild(imgcontainer);



    var txtcontainer = document.createElement("div");
    txtcontainer.classList.add('text-container');
    txtcontainer.setAttribute("id", "txtcontainer" + i);
    document.getElementById("container" + i).appendChild(txtcontainer);

    var img2 = document.createElement('img');
    img2.src = img;
    img2.classList.add('realimg');
    document.getElementById("imgcontainer" + i).appendChild(img2);

    var song_name = document.createElement("div");
    song_name.classList.add('product-info');
    song_name.setAttribute("id", "song_name" + i);
    song_name.innerHTML = title;
    document.getElementById("txtcontainer" + i).appendChild(song_name);

    var artists_name = document.createElement("div");
    artists_name.classList.add('product-info');
    artists_name.setAttribute("id", "artists_name" + i);
    artists_name.innerHTML = artists + "<br>";
    document.getElementById("txtcontainer" + i).appendChild(artists_name);

    var x = document.createElement("BR");


    list.insertBefore(x, container);




}

// function breaks() {
//     var div = document.getElementById("list");
//
//     // Get all span elements inside of div
//     var spans = div.getElementsByClassName("container");
//
//     // Create a loop which will insert a br element before each span element in div, starting from the second span element
//     var i;
//     for (i = 1; i < spans.length; i++) {
//         var newElem = document.createElement("BR");
//         div.insertBefore(newElem, spans[i]);
//     }
// }


//




const app = new Vue({
    el: '#app',
    data() {
        return {
            client_id: '42f6854dd8ed4408a4ad3a7b52303250',
            my_scopes: '%2cugc-image-upload%2cuser-read-recently-played%2cuser-top-read%2cuser-read-playback-position%2cuser-read-playback-state%2cuser-modify-playback-state%2cuser-read-currently-playing%2capp-remote-control%2cstreaming%2cplaylist-modify-public%2cplaylist-modify-private%2cplaylist-read-private%2cplaylist-read-collaborative%2cuser-follow-modify%2cuser-follow-read%2cuser-library-modify%2cuser-library-read%2c',
            redirect_uri: 'https://alexanderswann.github.io/DSA/',
            me: null,
            top: null,
            my_token: ""
        }
    },
    methods: {
        login() {
            var popup = window.open(`https://accounts.spotify.com/authorize?client_id=${this.client_id}&response_type=token&redirect_uri=${this.redirect_uri}&scope=${this.my_scopes}&show_dialog=true`, 'Login with Spotify', 'width=800,height=600')

            window.spotifyCallback = (payload) => {
                //alert(payload)

                this.my_token = payload

                popup.close()

                fetch('https://api.spotify.com/v1/me', {
                    headers: {
                        'Authorization': `Bearer ${this.my_token}`
                    }
                }).then(response => {
                    return response.json()
                }).then(data => {
                    userid(data)
                })
            }
            this.me = "true";

        },

        topsongs() {
            //alert(this.my_token)
            token(this.my_token)
            fetch('https://api.spotify.com/v1/me/top/tracks?time_range=short_term&limit=50', {
                headers: {
                    'Authorization': `Bearer ${this.my_token}` //'Bearer BQChB1cyLGz66SZqax2CM6lpEG8jFDHppZtDxmlzNtyz_LIlNIAu5qWKRMC6tMwkK5WE4z_GfO6SHEcywknltbQf9lZc_6DE9PsT6A1V_BmBW2pvzAMWFrM8lPHvHCjrFcIQMrLaPEwf8c5KAv4SsYY7LtNXY0oBFqDQ_C2cmoJIYQgXSfhrG0_xO7nLV0Vgqt8xngfN19XoJQxny9bDdT4q4SoHVBYlsDITQgwtKNbdTUvIy6HohmP4wtq5hH_vD9vvR81WLsznuFjJh5QLlJoTBFI'

                }
            }).then(response => {
                return response.json()
            }).then(data => {
                printtop(data)




            })




            //fetch('https://accounts.spotify.com/api/token?grant_type=authorization_code&code=' + this.my_token + '&redirect_uri=' + this.redirect_uri + '&client_id=' + this.client_id + '&client_secret=' + '90cf7eab479e4773945085484f3c2df4').then(response => {return response.json()}).then(data2 => {this.top = data2})
            //alert('https://accounts.spotify.com/api/token?grant_type=authorization_code&code=' + this.my_token + '&redirect_uri=' + this.redirect_uri + '&client_id=' + this.client_id + '&client_secret=' + '90cf7eab479e4773945085484f3c2df4')
            //this.top = this.me

        }


    },
    mounted() {
        this.token = window.location.hash.substr(1).split('&')[0].split("=")[1]

        if (this.token) {
            //alert(this.token)



            window.opener.spotifyCallback(this.token)
        }
    }
})

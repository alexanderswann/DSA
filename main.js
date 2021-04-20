// var CLIENTID = "42f6854dd8ed4408a4ad3a7b52303250";
// var CLIENTSECRET = "90cf7eab479e4773945085484f3c2df4";
// var CLIENTIDQ = "NDJmNjg1NGRkOGVkNDQwOGE0YWQzYTdiNTIzMDMyNTA=";
// var CLIENTSECREQ = ":OTBjZjdlYWI0NzllNDc3Mzk0NTA4NTQ4NGYzYzJkZjQ=";
// var REDIRECTURL = "https://www.spotify.com/us/home/";
// var scopes = "%2cugc-image-upload%2cuser-read-recently-played%2cuser-top-read%2cuser-read-playback-position%2cuser-read-playback-state%2cuser-modify-playback-state%2cuser-read-currently-playing%2capp-remote-control%2cstreaming%2cplaylist-modify-public%2cplaylist-modify-private%2cplaylist-read-private%2cplaylist-read-collaborative%2cuser-follow-modify%2cuser-follow-read%2cuser-library-modify%2cuser-library-read%2c";
// var refresh = "AQAzBYsvuKvMUj9bwTlghZal_d07EO9HHW4rblI-_aypVs31vJ89qdcHwwTmi0jfVJhQop9frRtilFFrFGaEU8-zdf9blr71qP8-BIWOzvgLxGY6pZi1ZGZWOSDqG7GrDmo";
//
// function setup(){
//
//     var button = select('#topsongs');
//   	button.mousePressed(topsongs);
//
// }
//
function topsongs(){

  var url_code = "https://accounts.spotify.com/api/token?grant_type=authorization_code" + "&code=" + app.me + "&redirect_uri=" + REDIRECTURL + "&client_id=" + CLIENTID + "&client_secret=" + CLIENTSECRET;
  loadJSON(url_code);
}






  const app = new Vue({
  el: '#app',
  data() {
    return {
      client_id: '42f6854dd8ed4408a4ad3a7b52303250',
      my_scopes:  '%2cugc-image-upload%2cuser-read-recently-played%2cuser-top-read%2cuser-read-playback-position%2cuser-read-playback-state%2cuser-modify-playback-state%2cuser-read-currently-playing%2capp-remote-control%2cstreaming%2cplaylist-modify-public%2cplaylist-modify-private%2cplaylist-read-private%2cplaylist-read-collaborative%2cuser-follow-modify%2cuser-follow-read%2cuser-library-modify%2cuser-library-read%2c',
      redirect_uri: 'https://alexanderswann.github.io/DSA/',
      me: null,
      top: null,
      my_token: null
    }
  },
  methods: {
    login() {
      let popup = window.open(`https://accounts.spotify.com/authorize?client_id=${this.client_id}&response_type=token&redirect_uri=${this.redirect_uri}&scope=${this.my_scopes}&show_dialog=true`, 'Login with Spotify', 'width=800,height=600')

      window.spotifyCallback = (payload) => {
        alert(payload)

        this.my_token = payload

        popup.close()

        fetch('https://api.spotify.com/v1/me/top/tracks?time_range=short_term&limit=5', {
          headers: {
            'Authorization': `Bearer ${payload}`
          }
        }).then(response => {
          return response.json()
        }).then(data => {
          this.me = data
        })
      }
    },

    topsongs() {
      fetch('https://accounts.spotify.com/api/token?grant_type=authorization_code&code=' + this.my_token + '&redirect_uri=' + this.redirect_uri + '&client_id=' + this.client_id + '&client_secret=' + '90cf7eab479e4773945085484f3c2df4').then(response => {return response.json()}).then(data2 => {this.top = data2})
      alert('https://accounts.spotify.com/api/token?grant_type=authorization_code&code=' + this.my_token + '&redirect_uri=' + this.redirect_uri + '&client_id=' + this.client_id + '&client_secret=' + '90cf7eab479e4773945085484f3c2df4')
      //this.top = this.me

    }


  },
  mounted() {
    this.token = window.location.hash.substr(1).split('&')[0].split("=")[1]

    if (this.token) {
      alert(this.token)



      window.opener.spotifyCallback(this.token)
    }
  }
})

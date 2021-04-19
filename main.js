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
// function topsongs(){
//
//   var url_code = "https://accounts.spotify.com/api/token?grant_type=authorization_code" + "&code=" + "AQCYpxlzwxtpiPpGE08Uk307T2wH0sZ8qLMNi_owGzSe2FFAVxN3jycnLOPHlGJyI_emdsho_b8EN-UxKZg32JL9MQRaavxjqqZY4dSLv5ebBKl-vBiYivxVi7v39DIE9mR7Aq6NvaoGjT0PGyKnPp-Un6XHw0nu_cHPRh4j1OUU79CIs-ldFQt1kASpn1kkX9bTB9rpLH4CyMzqY9rcmXMbyM-cKmVbbnhHVGpWbnxUpzwSEUpZ4CddFyB5l7htwgV0KrlUT0SbC-GXZ-zLb5_5UPCENPBtKaUtHFnCgGSvQ_qqvvjEbkoQRRbVj3fUE8ZyX2Gab4cB_rhefJAijOqSVIDQvCmjY2RbIowtGXDohJ1hgAtzybNC8NZGhYzzZj_eMq5Hmof06HQSrMOFhYZBR3Iu32zd3Gw6dZetPq9hw-pm4Sy5mUL9yqv3qKYEiTMloTFQ-eKQd88rDCa5wocT0ksbCvDgfkgxH_ENP22X6Xhc8gsgIa1VDsZOxtw0hShQw1YbpF284f-rAoHcUm-OzYZyE2mZ1dJ4cNXZz-FFez146JgRRs0PZIc2lyeZkehHOuPFCaUbO7UrdwmlTSEHjrhxootsgblCRA09fNOXR6tajL9Ku9RkzptY5avNG7YpFEP-V6xEsUjjkbxS0Z57LybQj4T_FtK1V4W8N0gCbaoHSgn0bfi_zobN9QD9N1D7bIIbO-YrrvxgMmpoZ1UbuWDCHQ" + "&redirect_uri=" + REDIRECTURL + "&client_id=" + CLIENTID + "&client_secret=" + CLIENTSECRET;
//   loadJSON(url_code);
// }
//
//
// function login(){
//     app.get('/login', function(req, res) {
//     var scopes = 'user-read-private user-read-email';
//     res.redirect('https://accounts.spotify.com/authorize' +
//       '?response_type=code' +
//       '&client_id=' + my_client_id +
//       (scopes ? '&scope=' + encodeURIComponent(scopes) : '') +
//       '&redirect_uri=' + encodeURIComponent(redirect_uri));
//     });
//
//   }




  const app = new Vue({
  el: '#app',
  data() {
    return {
      client_id: '42f6854dd8ed4408a4ad3a7b52303250',
      scopes:  '%2cugc-image-upload%2cuser-read-recently-played%2cuser-top-read%2cuser-read-playback-position%2cuser-read-playback-state%2cuser-modify-playback-state%2cuser-read-currently-playing%2capp-remote-control%2cstreaming%2cplaylist-modify-public%2cplaylist-modify-private%2cplaylist-read-private%2cplaylist-read-collaborative%2cuser-follow-modify%2cuser-follow-read%2cuser-library-modify%2cuser-library-read%2c',
      redirect_uri: 'https://alexanderswann.github.io/DSA/',
      me: null
    }
  },
  methods: {
    login() {
      let popup = window.open(`https://accounts.spotify.com/authorize?client_id=${this.client_id}&response_type=token&redirect_uri=${this.redirect_uri}&scope=${this.scopes}&show_dialog=true`, 'Login with Spotify', 'width=800,height=600')

      window.spotifyCallback = (payload) => {
        alert(payload)

        popup.close()

        fetch('https://api.spotify.com/v1/me', {
          headers: {
            'Authorization': `Bearer ${payload}`
          }
        }).then(response => {
          return response.json()
        }).then(data => {
          this.me = data
        })
      }
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

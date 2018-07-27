<template>
  <div id="app">
    <Navbar1/>
    <h5>{{user.name}}</h5>
    <router-view></router-view>
  </div>
</template>

<script>
import Navbar1 from './components/navbar/navbar-1'

export default {
  name: 'App',
  data () {
    return {
      user: {}
    }
  },
  created: function () {
    console.log('created')
    // Alias the component instance as `vm`, so that we
    // can access it inside the promise function
    var vm = this

    // Fetch our array of posts from an API
    fetch('http://localhost:8080/api/user/1')
      .then(function (response) {
        return response.json()
      })
      .then(function (data) {
        console.log(data)
        vm.user = data
      })
  },
  components: { Navbar1 }
}
</script>

<style>
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>

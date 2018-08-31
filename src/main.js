// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import BootstrapVue from 'bootstrap-vue'
import VueRouter from 'vue-router'

import App from './App'
import UserEmailsSubscriptions from './components/main/UserEmailsSubscriptions'
import Homepage from './components/main/homepage'
import Table1 from './components/main/table-basic-1'

Vue.use(VueRouter)
Vue.use(BootstrapVue)

Vue.config.productionTip = false
const UserSettingsNav = {
  template: `
    <div class="us__nav">
      <b-list-group>
        <b-list-group-item href="/settings/profile">profile</b-list-group-item>
        <b-list-group-item href="/settings/emails">emails</b-list-group-item>
        <b-list-group-item href="#">Action links are easy</b-list-group-item>
        <b-list-group-item href="#foobar" disabled>Disabled link</b-list-group-item>
      </b-list-group>
    </div>
    `
}

const UserSettings = {
  template: `
  <div class="us">
    <UserSettingsNav/>
    <router-view class ="us__content"/>
    <router-view name="helper" class="us__content us__content--helper"/>
  </div>
  `,
  components: { UserSettingsNav }
}

const UserProfile = {
  template: `
  <div>
    <h3>Edit your profile</h3>
  </div>
  `
}

const UserProfilePreview = {
  template: `
  <div>
    <h3>Preview of your profile</h3>
  </div>
  `
}

const router = new VueRouter({
  mode: 'history',
  routes: [
    { path: '', component: Homepage },
    { path: '/users', component: Table1 },
    { path: '/settings',
      // You could also have named views at tho top
      component: UserSettings,
      children: [{
        path: 'emails',
        component: UserEmailsSubscriptions
      }, {
        path: 'profile',
        components: {
          default: UserProfile,
          helper: UserProfilePreview
        }
      }]
    }
  ]
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router, // （缩写）相当于 router: router
  components: { App },
  template: '<App/>'
})

// router.push('/settings/emails')
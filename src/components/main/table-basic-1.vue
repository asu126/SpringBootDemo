<template>
  <b-container fluid>
    <!-- User Interface controls -->
    <b-row>
      <b-col md="6" class="my-1">
        <b-form-group horizontal label="Filter" class="mb-0">
          <b-input-group>
            <b-form-input v-model="filter" placeholder="Type to Search" />
            <b-input-group-append>
              <b-btn :disabled="!filter" @click="filter = ''">Clear</b-btn>
            </b-input-group-append>
          </b-input-group>
        </b-form-group>
      </b-col>
      <b-col md="6" class="my-1">
        <b-form-group horizontal label="Sort" class="mb-0">
          <b-input-group>
            <b-form-select v-model="sortBy" :options="sortOptions">
              <option slot="first" :value="null">-- none --</option>
            </b-form-select>
            <b-form-select :disabled="!sortBy" v-model="sortDesc" slot="append">
              <option :value="false">Asc</option>
              <option :value="true">Desc</option>
            </b-form-select>
          </b-input-group>
        </b-form-group>
      </b-col>
      <b-col md="6" class="my-1">
        <b-form-group horizontal label="Sort direction" class="mb-0">
          <b-input-group>
            <b-form-select v-model="sortDirection" slot="append">
              <option value="asc">Asc</option>
              <option value="desc">Desc</option>
              <option value="last">Last</option>
            </b-form-select>
          </b-input-group>
        </b-form-group>
      </b-col>
      <b-col md="6" class="my-1">
        <b-form-group horizontal label="Per page" class="mb-0">
          <b-form-select :options="pageOptions" v-model="perPage" />
        </b-form-group>
      </b-col>

      <!-- add new user-->
      <b-col md="6" class="my-1 hidden">
        <div class="hidden">
          <label>name:</label>
          <input v-model="newUser.name" placeholder="edit me">
          <label>age:</label>
          <input v-model="newUser.age" placeholder="18">
          <p>user age is: {{ newUser.age }}</p>
          <b-button  @click="createUser">Add new user</b-button>
        </div>
      </b-col>
      <!--end add new user-->
    </b-row>

    <!-- Main table element -->
    <b-table show-empty
             stacked="md"
             :items="items"
             :fields="fields"
             :current-page="currentPage"
             :per-page="perPage"
             :filter="filter"
             :sort-by.sync="sortBy"
             :sort-desc.sync="sortDesc"
             :sort-direction="sortDirection"
             @filtered="onFiltered"
    >
      <template slot="name" slot-scope="row">{{row.value}}</template>
      <template slot="isActive" slot-scope="row">{{row.value?'Yes :)':'No :('}}</template>
      <template slot="actions" slot-scope="row">
        <!-- We use @click.stop here to prevent a 'row-clicked' event from also happening -->
        <b-button size="sm" @click.stop="info(row.item, row.index, $event.target)" class="mr-1">
          Info modal
        </b-button>
        <b-button size="sm" @click.stop="row.toggleDetails">
          {{ row.detailsShowing ? 'Hide' : 'Show' }} Details
        </b-button>
      </template>
      <template slot="row-details" slot-scope="row">
        <b-card>
          <ul>
            <li v-for="(value, key) in row.item" :key="key">{{ key }}: {{ value}}</li>
          </ul>
        </b-card>
      </template>
    </b-table>

    <b-row>
      <b-col md="6" class="my-1">
        <b-pagination :total-rows="totalRows" :per-page="perPage" v-model="currentPage" @click.native="testFunc" class="my-0" />
      </b-col>
    </b-row>

    <!-- Info modal -->
    <b-modal id="modalInfo" @hide="resetModal" :title="modalInfo.title" ok-only>
      <pre>{{ modalInfo.content }}</pre>
    </b-modal>

  </b-container>
</template>

<script>
/**
const items = [
  { isActive: true, age: 40, name: 'Dickerson Macdonald' },
  { isActive: false, age: 21, name: 'Larsen Shaw' },
  {
    isActive: false,
    age: 9,
    name: 'Mini Navarro',
    _rowVariant: 'success'
  },
  { isActive: false, age: 89, name: 'Geneva Wilson' },
  { isActive: true, age: 38, name: 'Jami Carney' },
  { isActive: false, age: 27, name: 'Essie Dunlap' },
  { isActive: true, age: 40, name: 'Thor Macdonald' },
  {
    isActive: true,
    age: 87,
    name: 'Larsen Shaw',
    _cellVariants: { age: 'danger', isActive: 'warning' }
  },
  { isActive: false, age: 26, name: 'Mitzi Navarro' },
  { isActive: false, age: 22, name: 'Genevieve Wilson' },
  { isActive: true, age: 38, name: 'John Carney' },
  { isActive: false, age: 29, name: 'Dick Dunlap' }
]
*/

import $ from 'jquery'
export default {
  data () {
    return {
      items: [],
      fields: [
        { key: 'name', label: 'Person Full name', sortable: true, sortDirection: 'desc' },
        { key: 'age', label: 'Person age', sortable: true, 'class': 'text-center' },
        { key: 'isActive', label: 'is Active' },
        { key: 'actions', label: 'Actions' }
      ],
      currentPage: 1,
      perPage: 5,
      totalRows: 0,
      pageOptions: [ 5, 10, 15 ],
      sortBy: null,
      sortDesc: false,
      sortDirection: 'asc',
      filter: null,
      modalInfo: { title: '', content: '' },
      newUser: {}
    }
  },
  created: function () {
    console.log('created')
    // Alias the component instance as `vm`, so that we
    // can access it inside the promise function
    var vm = this

    // Fetch our array of posts from an API
    fetch('http://localhost:8080/api/user')
      .then(function (response) {
        console.log('headers的类型 X-Total-Page：' + response.headers.get('X-Total-Page'))
        vm.totalRows = parseInt(response.headers.get('X-Total-Page'))
        return response.json()
      })
      .then(function (data) {
        console.log(data)
        vm.items = data
      })
  },
  computed: {
    sortOptions () {
      // Create an options list from our fields
      return this.fields
        .filter(f => f.sortable)
        .map(f => { return { text: f.label, value: f.key } })
    }
  },
  methods: {
    info (item, index, button) {
      this.modalInfo.title = `Row index: ${index}`
      this.modalInfo.content = JSON.stringify(item, null, 2)
      this.$root.$emit('bv::show::modal', 'modalInfo', button)
    },
    resetModal () {
      this.modalInfo.title = ''
      this.modalInfo.content = ''
    },
    onFiltered (filteredItems) {
      // Trigger pagination to update the number of buttons/pages due to filtering
      // this.totalRows = filteredItems.length
      this.currentPage = 1
    },
    testFunc: function (event) {
      // `this` 在方法里指向当前 Vue 实例
      alert('Hello ' + this.currentPage + '!')
      // `event` 是原生 DOM 事件
      // if (event) {
      //   alert(event.target.tagName)
      // }
    },
    createUser: function (event) {
      // `this` 在方法里指向当前 Vue 实例
      // alert('Hello ' + this.newUser.name + this.newUser.age + '!')
      // $.ajax({
      //   url: "http://localhost:8080/greeting"
      // }).then(function(data, status, jqxhr) {
      //   $('.greeting-id').append(data.id);
      //   $('.greeting-content').append(data.content);
      //   console.log(jqxhr);
      // });

      $.post('http://localhost:8080/api/user',
        {
          name: this.newUser.name, // 'Donald Duck',
          age: this.newUser.age
        },
        function (data, status) {
          alert('数据：' + data + '\n状态：' + status)
        })

      // fetch('http://localhost:8080/api/user', {
      //   method: 'POST',
      //   mode: 'cors',
      //   headers: {
      //     'Content-Type': 'application/x-www-form-urlencoded'
      //   },
      //   body: "name='123'"
      // }).then(function (response) {
      //   // do sth
      //   console.log(response)
      // })
    }
  }
}
</script>

<style>
  // div.hidden {display:none;}
</style>

import Vue from 'vue'
import router from './router'

import BootstrapVue from "bootstrap-vue"

import App from './App'

import Default from './Layout/Wrappers/baseLayout.vue';
import Pages from './Layout/Wrappers/pagesLayout.vue';
import 'element-ui/lib/theme-chalk/index.css'
import ElementUi from 'element-ui'
import Axios from 'axios';

import VueMaterial from 'vue-material'
import 'vue-material/dist/vue-material.min.css'
import 'vue-material/dist/theme/default.css'
import './assets/seoulit.css'
import { DataTables, DataTablesServer } from 'vue-data-tables'
import lang from 'element-ui/lib/locale/lang/en'
import locale from 'element-ui/lib/locale'
import util from './util/util.js'
import './icon-font-dest/icon-font-dest.css'
Vue.config.productionTip = false;

Vue.use(BootstrapVue);
Vue.use(ElementUi)
Vue.use(router)
Vue.use(VueMaterial)

locale.use(lang)
Vue.use(DataTables)
Vue.use(DataTablesServer)

Vue.prototype.$http = Axios
Vue.prototype.$util = util

Vue.use(util)
Vue.component('default-layout', Default);
Vue.component('userpages-layout', Pages);

new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: { App }
});

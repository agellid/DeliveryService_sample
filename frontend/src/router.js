
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import PaymentManagementManager from "./components/listers/PaymentManagementCards"
import PaymentManagementDetail from "./components/listers/PaymentManagementDetail"

import OrderDataManager from "./components/listers/OrderDataCards"
import OrderDataDetail from "./components/listers/OrderDataDetail"

import DeliveryManager from "./components/listers/DeliveryCards"
import DeliveryDetail from "./components/listers/DeliveryDetail"

import SmsMessageManager from "./components/listers/SmsMessageCards"
import SmsMessageDetail from "./components/listers/SmsMessageDetail"


import OrderDashboardView from "./components/OrderDashboardView"
import OrderDashboardViewDetail from "./components/OrderDashboardViewDetail"
import StoreManager from "./components/listers/StoreCards"
import StoreDetail from "./components/listers/StoreDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/paymentManagements',
                name: 'PaymentManagementManager',
                component: PaymentManagementManager
            },
            {
                path: '/paymentManagements/:id',
                name: 'PaymentManagementDetail',
                component: PaymentManagementDetail
            },

            {
                path: '/orderData',
                name: 'OrderDataManager',
                component: OrderDataManager
            },
            {
                path: '/orderData/:id',
                name: 'OrderDataDetail',
                component: OrderDataDetail
            },

            {
                path: '/deliveries',
                name: 'DeliveryManager',
                component: DeliveryManager
            },
            {
                path: '/deliveries/:id',
                name: 'DeliveryDetail',
                component: DeliveryDetail
            },

            {
                path: '/smsMessages',
                name: 'SmsMessageManager',
                component: SmsMessageManager
            },
            {
                path: '/smsMessages/:id',
                name: 'SmsMessageDetail',
                component: SmsMessageDetail
            },


            {
                path: '/orderDashboards',
                name: 'OrderDashboardView',
                component: OrderDashboardView
            },
            {
                path: '/orderDashboards/:id',
                name: 'OrderDashboardViewDetail',
                component: OrderDashboardViewDetail
            },
            {
                path: '/stores',
                name: 'StoreManager',
                component: StoreManager
            },
            {
                path: '/stores/:id',
                name: 'StoreDetail',
                component: StoreDetail
            },



    ]
})

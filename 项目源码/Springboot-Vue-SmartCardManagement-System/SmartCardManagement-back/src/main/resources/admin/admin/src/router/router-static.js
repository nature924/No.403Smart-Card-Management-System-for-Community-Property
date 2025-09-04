import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import cheliangruku from '@/views/modules/cheliangruku/list'
    import dictionary from '@/views/modules/dictionary/list'
    import feiyong from '@/views/modules/feiyong/list'
    import liuyan from '@/views/modules/liuyan/list'
    import news from '@/views/modules/news/list'
    import yezhufuwu from '@/views/modules/yezhufuwu/list'
    import yezhufuwuCommentback from '@/views/modules/yezhufuwuCommentback/list'
    import yonghu from '@/views/modules/yonghu/list'
    import dictionaryCheliangruku from '@/views/modules/dictionaryCheliangruku/list'
    import dictionaryChuru from '@/views/modules/dictionaryChuru/list'
    import dictionaryFeiyong from '@/views/modules/dictionaryFeiyong/list'
    import dictionaryNews from '@/views/modules/dictionaryNews/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryYezhufuwu from '@/views/modules/dictionaryYezhufuwu/list'
    import dictionaryYezhufuwuYesno from '@/views/modules/dictionaryYezhufuwuYesno/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryCheliangruku',
        name: '车辆状态',
        component: dictionaryCheliangruku
    }
    ,{
        path: '/dictionaryChuru',
        name: '出入类型',
        component: dictionaryChuru
    }
    ,{
        path: '/dictionaryFeiyong',
        name: '费用类型',
        component: dictionaryFeiyong
    }
    ,{
        path: '/dictionaryNews',
        name: '公告类型',
        component: dictionaryNews
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryYezhufuwu',
        name: '服务类型',
        component: dictionaryYezhufuwu
    }
    ,{
        path: '/dictionaryYezhufuwuYesno',
        name: '处理状态',
        component: dictionaryYezhufuwuYesno
    }


    ,{
        path: '/cheliangruku',
        name: '停车登记',
        component: cheliangruku
      }
    ,{
        path: '/dictionary',
        name: '字典表',
        component: dictionary
      }
    ,{
        path: '/feiyong',
        name: '费用信息',
        component: feiyong
      }
    ,{
        path: '/liuyan',
        name: '留言版',
        component: liuyan
      }
    ,{
        path: '/news',
        name: '公告信息',
        component: news
      }
    ,{
        path: '/yezhufuwu',
        name: '业主服务',
        component: yezhufuwu
      }
    ,{
        path: '/yezhufuwuCommentback',
        name: '服务评价',
        component: yezhufuwuCommentback
      }
    ,{
        path: '/yonghu',
        name: '业主',
        component: yonghu
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;

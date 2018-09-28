import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

/*
-------------------------------------------------------------------------------------
Local Components
-------------------------------------------------------------------------------------
*/

import { PageNotFoundComponent } 	from './page-not-found/page-not-found.component';
import { HomeComponent }			from './home-component/home.component';
import { MainComponent }			from './main-component/main.component';
import { ProfileComponent }			from './profile/profile.component';

const appRoutes: Routes = [
  {
    path: '',
    component: MainComponent,
    pathMatch: 'full',
    data: {
      breadcrumb: 'Welcome',
      longTitle: 'Welcome Main Component'
    }
  },
  {
    path: 'profile',
    component: ProfileComponent,
    data: {
      breadcrumb: 'Profile',
      longTitle: 'Registration Profile'
    }
  },
  {
    path: '**',
    component: PageNotFoundComponent,
    data: {
      breadcrumb: 'page not found'
    }
  }

];

@NgModule({
  imports: [
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: false} // <-- debugging purposes only
    )
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }

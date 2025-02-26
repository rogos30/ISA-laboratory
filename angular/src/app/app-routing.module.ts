import {RouterModule, Routes} from '@angular/router';
import {AlienListComponent} from './alien/view/alien-list/alien-list.component';
import {AlienViewComponent} from './alien/view/alien-view/alien-view.component';
import {AlienEditComponent} from './alien/view/alien-edit/alien-edit.component';
import {NgModule} from '@angular/core';
import {AlienAddComponent} from './alien/view/alien-add/alien-add.component';
import {MothershipListComponent} from './mothership/view/mothership-list/mothership-list.component';
import {MothershipViewComponent} from './mothership/view/mothership-view/mothership-view.component';
import {MothershipAddComponent} from './mothership/view/mothership-add/mothership-add.component';
import {MothershipEditComponent} from './mothership/view/mothership-edit/mothership-edit.component';

const routes: Routes = [
  {
    component: AlienListComponent,
    path: "aliens"
  },
  {
    component: AlienAddComponent,
    path: "aliens/add"
  },
  {
    component: AlienViewComponent,
    path: "aliens/:uuid"
  },
  {
    component: AlienEditComponent,
    path: "aliens/:uuid/edit"
  },
  {
    component: MothershipListComponent,
    path: "motherships"
  },
  {
    component: MothershipAddComponent,
    path: "motherships/add"
  },
  {
    component: MothershipViewComponent,
    path: "motherships/:uuid"
  },
  {
    component: MothershipEditComponent,
    path: "motherships/:uuid/edit"
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {

}

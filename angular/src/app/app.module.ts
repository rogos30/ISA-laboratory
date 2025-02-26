import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {FooterComponent} from './component/footer/footer.component';
import {HeaderComponent} from './component/header/header.component';
import {NavComponent} from './component/nav/nav.component';
import {MainComponent} from './component/main/main.component';
import {AlienListComponent} from './alien/view/alien-list/alien-list.component';
import {AlienEditComponent} from './alien/view/alien-edit/alien-edit.component';
import {AlienViewComponent} from './alien/view/alien-view/alien-view.component';
import {BrowserModule} from '@angular/platform-browser';
import {AppRoutingModule} from './app-routing.module';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {AlienService} from './alien/service/alien.service';
import {AlienAddComponent} from './alien/view/alien-add/alien-add.component';
import {MothershipListComponent} from './mothership/view/mothership-list/mothership-list.component';
import {MothershipViewComponent} from './mothership/view/mothership-view/mothership-view.component';
import {MothershipService} from './mothership/service/mothership.service';
import {MothershipEditComponent} from './mothership/view/mothership-edit/mothership-edit.component';
import {MothershipAddComponent} from './mothership/view/mothership-add/mothership-add.component';

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    NavComponent,
    MainComponent,
    AlienListComponent,
    AlienEditComponent,
    AlienViewComponent,
    AlienAddComponent,
    MothershipListComponent,
    MothershipEditComponent,
    MothershipViewComponent,
    MothershipAddComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    AlienService,
    MothershipService
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule {

}

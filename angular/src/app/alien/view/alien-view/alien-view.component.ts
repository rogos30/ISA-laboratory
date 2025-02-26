import {Component, OnInit} from '@angular/core';
import {AlienService} from '../../service/alien.service';
import {AlienDetails} from '../../model/alien-details';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-alien-view',
  templateUrl: './alien-view.component.html',
  standalone: false,
  styleUrls: ['./alien-view.component.css']
})
export class AlienViewComponent implements OnInit {
  constructor(private service: AlienService, private route: ActivatedRoute, private router: Router) {
  }

  alien: AlienDetails | undefined;

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getAlien(params['uuid'])
        .subscribe(alien => this.alien = alien)
    });
  }
}

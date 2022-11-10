import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PostFlightComponent } from './post-flight.component';

describe('PostFlightComponent', () => {
  let component: PostFlightComponent;
  let fixture: ComponentFixture<PostFlightComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PostFlightComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PostFlightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

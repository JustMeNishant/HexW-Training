import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PostSuccessfulComponent } from './post-successful.component';

describe('PostSuccessfulComponent', () => {
  let component: PostSuccessfulComponent;
  let fixture: ComponentFixture<PostSuccessfulComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PostSuccessfulComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PostSuccessfulComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

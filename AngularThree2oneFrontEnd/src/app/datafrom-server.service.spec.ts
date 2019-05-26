import { TestBed, inject } from '@angular/core/testing';

import { DatafromServerService } from './datafrom-server.service';

describe('DatafromServerService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DatafromServerService]
    });
  });

  it('should be created', inject([DatafromServerService], (service: DatafromServerService) => {
    expect(service).toBeTruthy();
  }));
});

package phuc.ygtm.pomodoro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import phuc.ygtm.pomodoro.dto.PConfigDto;
import phuc.ygtm.pomodoro.service.PConfigService;

@RestController
@RequestMapping("/p/config")
public class PConfigController {

    @Autowired
    private PConfigService pConfigService;

    @GetMapping()
    public ResponseEntity<PConfigDto> getConfig() {
        return ResponseEntity.ok(pConfigService.getConfig());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PConfigDto> updateConfig(@RequestBody PConfigDto config) {
        return ResponseEntity.ok(pConfigService.updateConfig(config));
    }

}

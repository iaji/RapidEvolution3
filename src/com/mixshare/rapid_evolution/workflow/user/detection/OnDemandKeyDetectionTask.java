package com.mixshare.rapid_evolution.workflow.user.detection;

import org.apache.log4j.Logger;

import com.mixshare.rapid_evolution.RE3Properties;
import com.mixshare.rapid_evolution.data.DataConstants;
import com.mixshare.rapid_evolution.data.record.search.song.SongRecord;
import com.mixshare.rapid_evolution.workflow.CommonTask;
import com.mixshare.rapid_evolution.workflow.detection.key.KeyDetectionTask;

public class OnDemandKeyDetectionTask extends CommonTask implements DataConstants {
	
    static private final long serialVersionUID = 0L;    	
    static private Logger log = Logger.getLogger(OnDemandKeyDetectionTask.class);	
	
	private SongRecord song;
	
	public OnDemandKeyDetectionTask(SongRecord song) {
		this.song = song;
	}
	
	public String toString() { return "Detecting key for " + song; }
	
	public void execute() {
		try {
			if (song != null)
				KeyDetectionTask.detectKey(song, this);
		} catch (Exception e) {
			log.error("execute(): error", e);
		}
	}

	public int getTaskPriority() { return RE3Properties.getInt("default_task_priority") + 5; }
	
}

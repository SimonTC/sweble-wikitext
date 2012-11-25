/**
 * Copyright 2011 The Open Source Research Group,
 *                University of Erlangen-Nürnberg
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.sweble.wikitext.articlecruncher;

public final class ProcessedJob
{
	private final JobProcessingState state;
	
	private final Job job;
	
	private final Result result;
	
	// =========================================================================
	
	/*
	public ProcessedJob(JobProcessingState state, Job job, Result result)
	{
		this.state = state;
		this.job = job;
		this.result = result;
	}
	*/
	
	public ProcessedJob(Job job, Throwable t)
	{
		this.state = JobProcessingState.FAILED;
		this.job = job;
		this.result = new Result(job, t);
	}
	
	public ProcessedJob(Job job, Result result)
	{
		this.state = JobProcessingState.HAS_RESULT;
		this.job = job;
		this.result = result;
	}
	
	// =========================================================================
	
	public JobProcessingState getState()
	{
		return state;
	}
	
	public Result getResult()
	{
		return result;
	}
	
	public Job getJob()
	{
		return job;
	}
}

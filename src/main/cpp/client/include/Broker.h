/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
#pragma once

#include <memory>
#include <vector>

#include "ServiceAddress.h"

ROCKETMQ_NAMESPACE_BEGIN

class Broker {
public:
  Broker(std::string name, int id, ServiceAddress service_address)
      : name_(std::move(name)), id_(id), service_address_(std::move(service_address)) {
  }

  const std::string& name() const {
    return name_;
  }

  int32_t id() const {
    return id_;
  }

  explicit operator bool() const {
    return service_address_.operator bool();
  }

  bool operator==(const Broker& other) const {
    return name_ == other.name_;
  }

  bool operator<(const Broker& other) const {
    return name_ < other.name_;
  }

  std::string serviceAddress() const {
    return service_address_.address();
  }

private:
  std::string name_;
  int32_t id_;
  ServiceAddress service_address_;
};

ROCKETMQ_NAMESPACE_END